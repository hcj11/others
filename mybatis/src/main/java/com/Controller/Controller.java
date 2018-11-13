package com.Controller;

import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcj on 18-7-16
 */
@RestController
public class Controller {

  @Autowired
  UserService userService;

  @GetMapping("insert")
  public void transactionTestWithInsert() {
    userService.insert();
  }

  @GetMapping("select")
  public ResponseEntity transactionTestWithSelect() {

    return ResponseEntity.ok(userService.findUser().size());

  }
}
