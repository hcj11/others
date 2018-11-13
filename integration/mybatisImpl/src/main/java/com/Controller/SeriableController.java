package com.Controller;

import com.Service.ReadAndCommit;
import com.Service.Seriable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcj on 18-7-16
 */
@RestController
@RequestMapping("/seriable")
public class SeriableController {

  @Autowired
  Seriable seriable;

  @PostMapping("insert")
  public void transactionTestWithInsert() throws Exception {
    seriable.insert();
  }

  @GetMapping("select")
  public void insertAndRead() {
    seriable.getCount();
  }

}
