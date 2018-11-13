package com.Controller;

import com.Domain.Role;
import com.Domain.User;
import com.Mapper.RoleMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcj on 18-7-22
 */
@RestController
@RequestMapping("role")
public class RoleController {
  @Autowired
  RoleMapper mapper;

  @GetMapping("{id}")
  @ResponseBody
  public ResponseEntity<String> findOne(@PathVariable("id")Integer id) {
    List<Role> userList = mapper.findUserList(id);
    // cache 不支持级联缓存?
    for (Role role:userList){
      // 获取同一级别的userList ,并且 级联缓存,只会缓存一层, 所以此处需要进行判断,
      // 对于级联数据的缓存， 则可以改用放弃延迟加载来提高性能。

      List<User> userList1 = role.getUserList();
      if(userList1!=null){
        for (User user:userList1){
          System.out.println(user.getId());
        }

      }
          }
    return ResponseEntity.ok("");
  }
}
