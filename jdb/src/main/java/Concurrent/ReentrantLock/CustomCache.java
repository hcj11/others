package Concurrent.ReentrantLock;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by hcj on 18-7-18
 */
public class CustomCache<T> implements Cache<T> {
  // id ,
  private final HashMap<String, T> map = new HashMap<>();

  @Override
  public String getId() {
    return null;
  }

  @Override
  public void putObject(String key, T value) {
    map.put(key,value);
  }

  @Override
  public T getObject(String key) {
    return map.get(key);
  }

  @Override
  public Object removeObject(String key) {
    return map.remove(key);
  }

  @Override
  public void clear() {
    map.clear();
  }

  @Override
  public int getSize() {
    return map.size();
  }

  @Override
  public ReadWriteLock getReadWriteLock() {
    return null;
  }
}
