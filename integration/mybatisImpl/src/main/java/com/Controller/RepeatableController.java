package com.Controller;

import com.Service.RepeatableQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcj on 18-7-16
 */
@RestController
@RequestMapping("/Repeatable")
public class RepeatableController {

  @Autowired
  RepeatableQuestion repeatableQuestion;

  @PostMapping("insert")
  public void transactionTestWithInsert() throws Exception {
    repeatableQuestion.insert();
  }

  @GetMapping("select")
  public void insertAndRead() {
    repeatableQuestion.getCount();
  }

}
