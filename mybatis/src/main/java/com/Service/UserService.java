package com.Service;

import com.Domain.User;
import com.Mapper.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * cglib 代理 Created by hcj on 18-7-16
 */
@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  // 脏读
  @Transactional(isolation = Isolation.READ_UNCOMMITTED)
  public void insert() {
    User user = new User();
    user.setUsername("hch");
    user.setPassword("123");
    user.setEnabled(true);
    userMapper.insert(user);
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    throw new RuntimeException();
  }
  // 不开启事务
//  @Transactional(readOnly = true)
  public List<User> findUser() {
    return userMapper.selectAll();
  }

}
