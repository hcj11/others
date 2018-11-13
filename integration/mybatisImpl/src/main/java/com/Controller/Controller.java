package com.Controller;

import com.Domain.User;
import com.Service.UserService;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.LastModified;

/**
 * Created by hcj on 18-7-16
 */
@RestController
public class Controller implements LastModified{

  @Autowired
  UserService userService;
  private long lastModified;
  @Autowired
  ServletContext context;

  @PutMapping
  public void update(@RequestBody User user){
    userService.update(user);
  }


  @PostMapping("insertBatch")
  public void insertBatch() throws Exception {
    userService.insertBatch();
  }

  @PostMapping("insert")
  public void transactionTestWithInsert() throws Exception {
    userService.insert();
  }

  @GetMapping("select")
  @ResponseBody
  public ResponseEntity transactionTestWithSelect() {
    return ResponseEntity.ok(userService.findUser().get(0).getFeMaleHealths().get(0));
  }

  @GetMapping("{id}")
  @ResponseBody
  public ResponseEntity<User> findOne(@PathVariable("id")Integer id) {
    User one = userService.findOne(id);
    // cache 不支持级联缓存?
    return ResponseEntity.ok(one);
  }

  @GetMapping("insertAndRead")
  public void insertAndRead() {
    userService.insertAndRead();
  }

  @Override
  public long getLastModified(HttpServletRequest request) {
    //
    if (this.lastModified == 0) {
      lastModified = System.currentTimeMillis();
    }
    return lastModified;
  }
}
