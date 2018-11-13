package com.mshuoke.datagw.controller.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by hcj on 18-7-9
 */
@Setter
@Getter
@Configuration
public class DeferredResultEntity {
  private boolean isFlag;
  private DeferredResult<String> result;

}
