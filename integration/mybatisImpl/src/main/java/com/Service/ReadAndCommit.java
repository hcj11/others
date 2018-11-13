package com.Service;

import com.Domain.User;
import com.Mapper.UserMapper;
import java.util.List;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 读提交问题 Created by hcj on 18-7-16
 */
@Service
public class ReadAndCommit {

  @Autowired
  UserMapper userMapper;
  private Log logger = LogFactory.getLog(UserService.class);
  // Isolation.READ_COMMITTED or  Isolation.REPEATABLE_READ
  @Transactional(isolation = Isolation.READ_COMMITTED)
  public void getCount() {
    // 这里****注意*****由于缓存的存在,导致结果的不真实,  所以可以改变查询的方向来判断结果
    List<User> users = userMapper.selectAll();
    logger.warn("初始大小: " + users.toString());
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 增加了查询缓存?
    String hcj = userMapper.selectUser("hcj").getPassword();

    logger.warn("插入数据后的大小: " + hcj);
  }
  // 全局数据。
  // mysql默认自动提交事务 ,那么, 因为是成功的提交,
  // readOnly = true 设置到对应的conn下,so 可以不开启事务,
  @Transactional(readOnly = true)
  public void insert()  {
    User user = new User();
    user.setUsername("hcj");
    Random random = new Random();
    int i = random.nextInt(100);
    user.setPassword(i + "");
    userMapper.update(user);
  }



}
