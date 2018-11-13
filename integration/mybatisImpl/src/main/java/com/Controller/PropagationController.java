package com.Controller;

import com.Service.ProPagation.ProPagation;
import com.Service.Seriable;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcj on 18-7-16
 */
@RestController
@RequestMapping("/proPagation")
public class PropagationController implements EnvironmentAware{

  @Autowired
  ProPagation proPagation;

  @PostMapping("insert")
  public void transactionTestWithInsert() throws Exception {
    proPagation.insert();
  }

  @GetMapping("select")
  public void insertAndRead() {
    proPagation.getCount();
  }

  @Override
  public void setEnvironment(org.springframework.core.env.Environment environment) {
      System.out.println(environment);
  }
}
