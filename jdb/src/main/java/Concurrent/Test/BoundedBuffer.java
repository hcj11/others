package Concurrent.Test;

import java.util.concurrent.Semaphore;

/**
 * 正确性，并发测试 Created by hcj on 18-5-5 基于信号量的有界缓存
 */
public class BoundedBuffer<E> {

  // 数据存储容器 []  或者collection
  private E[] items;
  //   写入
  private final Semaphore availableItems, availableSpaces;

  private int putposition = 0, takeposition = 0;


  public BoundedBuffer(int MaxSize) {
    availableSpaces = new Semaphore(MaxSize);
    availableItems = new Semaphore(0);
    items = (E[]) new Object[MaxSize];
  }


  public void put(E x) throws InterruptedException {
    //  不断的将数据加入到缓存，直至有界缓存的上限
    availableSpaces.acquire();
    doInsert(x);
    // 可以获取
    availableItems.release();

  }

  private synchronized void doInsert(E x) {
    int i = putposition;
    items[i] = x;
    putposition = (++i == items.length) ? 0 : i;
  }

  public E take() throws InterruptedException {
    availableItems.acquire();
    // 数据获取
    E e = doExtract();
    availableSpaces.release();
    return e;
  }

  private synchronized E doExtract() {
    int i = takeposition;
    E x = items[i];
    items[i] = null;
    takeposition = (++i == items.length) ? 0 : i;
    return x;
  }

  public boolean isFull() {
    // 允许插入到缓存的量
    return availableSpaces.availablePermits() == 0;
  }

  public boolean isEmpty() {
    // 生产者的数量为0
    return availableItems.availablePermits() == 0;
  }

}
