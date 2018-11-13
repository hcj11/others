package Concurrent.ReentrantLock;

import Concurrent.ReentrantLock.Exception.CacheException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * blocking decorator Created by hcj on 18-7-18
 */
public class ReentrantCache<T> implements Cache<T> {

  private long timeout;
  private final Cache<T> delegate;
  // ConcurrentHashMap 的 key 作为标识, 判断多线程获取锁的竞争条件是否满足.
  // 分段锁, 确保写安全,
  private final ConcurrentHashMap<String, ReentrantLock> locks;

  public ReentrantCache(Cache<T> delegate) {
    this.delegate = delegate;
    this.locks = new ConcurrentHashMap<String, ReentrantLock>();
  }

  @Override
  public String getId() {
    return delegate.getId();
  }

  @Override
  public int getSize() {
    return delegate.getSize();
  }

  @Override
  public void putObject(String key, T value) {
    try {
      delegate.putObject(key, value);
    } finally {
      releaseLock(key);
    }
  }

  @Override
  public T getObject(String key) {
    acquireLock(key);
    T value = delegate.getObject(key);
    // 获取值之后,释放锁
    if (value != null) {
      releaseLock(key);
    }
    return value;
  }

  @Override
  public Object removeObject(String key) {
    // despite of its name, this method is called only to release locks
    releaseLock(key);
    return null;
  }

  @Override
  public void clear() {
    delegate.clear();
  }

  @Override
  public ReadWriteLock getReadWriteLock() {
    return null;
  }

  private ReentrantLock getLockForKey(String key) {

    ReentrantLock lock = new ReentrantLock();
    // 同步,
    ReentrantLock previous = locks.putIfAbsent(key, lock);
    // 之前已经有值, 那么由于之前的锁未释放,所以其他线程中都在阻塞着.
    System.out.println(previous);

    return previous == null ? lock : previous;
  }

  private void acquireLock(String key) {
    Lock lock = getLockForKey(key);
    if (timeout > 0) {
      try {
        boolean acquired = lock.tryLock(timeout, TimeUnit.MILLISECONDS);
        if (!acquired) {
          try {
            throw new CacheException(
                "Couldn't get a lock in " + timeout + " for the key " + key + " at the cache "
                    + delegate.getId());
          } catch (CacheException e) {
            e.printStackTrace();
          }
        }
      } catch (InterruptedException e) {
        try {
          throw new CacheException("Got interrupted while trying to acquire lock for key " + key,
              e);
        } catch (CacheException e1) {
          e1.printStackTrace();
        }
      }
    } else {
      // 否则直接锁住 , 直到其他线程提供该key
      lock.lock();
    }
  }

  private void releaseLock(String key) {
    // 读写锁，
    ReentrantLock lock = locks.get(key);
    // 写锁 排他锁,
    if (lock.isHeldByCurrentThread()) {
      lock.unlock();
    }
  }

  public long getTimeout() {
    return timeout;
  }

  public void setTimeout(long timeout) {
    this.timeout = timeout;
  }
}
