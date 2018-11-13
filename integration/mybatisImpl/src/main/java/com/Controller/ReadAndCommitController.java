package com.Controller;

import com.Service.ReadAndCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcj on 18-7-16
 */
@RestController
@RequestMapping("/ReadAndCommit")
public class ReadAndCommitController {

  @Autowired
  ReadAndCommit readAndCommit;

  @PostMapping("insert")
  public void transactionTestWithInsert() throws Exception {
    readAndCommit.insert();
  }

  @GetMapping("select")
  public void insertAndRead() {
    readAndCommit.getCount();
  }

}
