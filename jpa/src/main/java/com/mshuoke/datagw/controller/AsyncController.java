//package com.mshuoke.datagw.controller;
//
//import com.mshuoke.datagw.controller.utils.DeferredResultEntity;
//import com.mshuoke.datagw.controller.utils.DeferredResultHolder;
//import com.mshuoke.datagw.controller.utils.MockQueue;
//import java.util.concurrent.Callable;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.async.DeferredResult;
//
///**
// * Created by hcj on 18-7-9
// */
//@Slf4j
//@RestController
//public class AsyncController {
//
//  // map存储key,DeferredResult
//  @Autowired
//  private DeferredResultEntity deferredResultEntity;
//  @Autowired
//  private MockQueue mockQueue;
//
//
//  // 接受订单
//  @GetMapping("/getOrder")
//  public DeferredResult getOrder() {
//    log.info("主程序...");
//    // 时间戳
////    String orderNumber = RandomStringUtils.randomNumeric(8);
//
//    // 开启多线程去执行
////    mockQueue.addQueue(orderNumber);
//
//    DeferredResult<String> result = new DeferredResult<>();
//    //  DeferredResultHolder 独一份, 若是多线程的话,只是插入倒也无妨,待测试
//    // 放入到该result下
//    deferredResultEntity.setFlag(true);
//    deferredResultEntity.setResult(result);
//    return result;
//  }
//
//  @GetMapping("/callable")
//  public Callable callableTest() {
//    Callable callable = new Callable() {
//      @Override
//      public Object call() throws Exception {
//        Thread.sleep(1000);
//        System.out.println("副程序运行");
//        return "副程序"; // 返回给前端
//      }
//    };
//    System.out.println("主程序运行");
//    return callable;
//  }
//}
