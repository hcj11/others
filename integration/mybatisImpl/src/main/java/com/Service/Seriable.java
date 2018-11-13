package com.Service;

import com.Domain.User;
import com.Mapper.UserMapper;
import java.util.List;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 序列读  Created by hcj on 18-7-16
 */
@Service
public class Seriable {

  @Autowired
  UserMapper userMapper;

  private Log logger = LogFactory.getLog(UserService.class);
  // Isolation.READ_COMMITTED or  Isolation.REPEATABLE_READ
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public void getCount() {
    System.out.println();
    // 这里****注意*****由于缓存的存在,导致结果的不真实,  所以可以改变查询的方向来判断结果
    // 直接锁住数据表
    List<User> users = userMapper.selectAll(new RowBounds(0,5));
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

  // mysql默认自动提交事务 ,那么, 因为是成功的提交,
  @Transactional
  public void insert()  {
    System.out.println();
    User user = new User();
    user.setUsername("hcj");
    Random random = new Random();
    int i = random.nextInt(100);
    user.setPassword(i + "");
    userMapper.update(user);
  }


}
