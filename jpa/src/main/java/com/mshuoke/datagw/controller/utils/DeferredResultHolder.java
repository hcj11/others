package com.mshuoke.datagw.controller.utils;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by hcj on 18-7-9
 */
@Component
@Setter
@Getter
public class DeferredResultHolder {
  // 单例多线程, 难道不会导致
  private  HashMap<String, DeferredResult<String>> map = new HashMap<>();

}
