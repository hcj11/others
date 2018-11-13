package com.Controller;

import com.Domain.UserIdentity;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 * 异步处理器 Created by hcj on 18-7-20
 */
@RequestMapping("/async")
@RestController
public class AsyncController {
  private final static  ExecutorService executorService = Executors.newFixedThreadPool(10);
  @ResponseBody
  @GetMapping(value = "/callable",produces = "text/plain; charset=UTF-8")
  public Callable getResultWithCallable() {
    // 处理 耗时的操作使用, 推数据到客户端 ,关闭处理该任务的线程,  只有在异步请求全部处理完后才会关闭链接, 但是连接已经回收到线程池中
    System.out.println("主线程开始");
    Callable callable = new Callable<String>() {
      @Override
      public String call() throws Exception {
        Thread.sleep(1000);
        // 也可以返回空值,这个无所谓吧
        return "哈哈";
      }
    };
    System.out.println("主线程结束");
    return callable;
  }


  @GetMapping(value = "/webAsyncTask",produces = "text/plain; charset=UTF-8")
  public WebAsyncTask getResult() {
    System.out.println("主线程开始");
    // 提供一个自定义的线程池框架

    ConcurrentTaskExecutor concurrentTaskExecutor = new ConcurrentTaskExecutor(executorService);
    Callable callable = new Callable<String>() {
      @Override
      public String call() throws Exception {
        Thread.sleep(100);
        return "哈哈";
      }
    };
    WebAsyncTask webAsyncTask = new WebAsyncTask<Callable>(1000000L, concurrentTaskExecutor, callable);
    webAsyncTask.onCompletion(new MyRunnable());
    System.out.println("主线程结束");
    return webAsyncTask;
  }

  class MyRunnable implements Runnable {
    final int a = 1;
    @Override
    public void run() {
      System.out.println("完成了: " + a);
    }
  }

  /**
   * deferred 返回结果
   * ,produces = "text/plain; charset=UTF-8"
   */
  @ResponseBody
  @GetMapping(value = "/deferred")
  public DeferredResult getResultWithDeferredResult(){
    System.out.println("主线程开始");
    DeferredResult<UserIdentity> result = new DeferredResult<>();

    UserIdentity userIdentity = new UserIdentity();
    userIdentity.setAddress("123");
    // 构建一个多线程 执行该操作 ,
    executorService.submit(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          result.setResult(userIdentity);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    System.out.println("主线程结束, 等待子线程返回结果?");
    return result;
  }
// ResponseEntity
  // produces = "text/plain; charset=UTF-8"   响应的类型限制说明
  // consumes = "text/plain"  接收的类型说明
  @ResponseBody
  @GetMapping(value = "/listenableFuture")
  public ListenableFuture<ResponseEntity<UserIdentity>> getResultWithListenableFuture(){
    // 获取别的服务
    // 对象解析出现问题,
    ListenableFuture<ResponseEntity<UserIdentity>> forEntity = new AsyncRestTemplate()
        .getForEntity("http://localhost:8080/userIdentity/string", UserIdentity.class);
//    ListenableFuture<ResponseEntity<String>> forEntity = new AsyncRestTemplate()
//        .getForEntity("http://localhost:8080/userIdentity/string", String.class);

    return forEntity;
  }



}
