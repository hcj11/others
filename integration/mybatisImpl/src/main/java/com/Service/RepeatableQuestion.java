package com.Service;

import com.Domain.Sex;
import com.Domain.User;
import com.Mapper.UserMapper;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 重复读 , *可能* , 也可能[不出现], [出现] 幻读情况, 但是不会出现提交读的情况 Created by hcj on 18-7-16
 */
@Service
public class RepeatableQuestion {

  @Autowired
  UserMapper userMapper;
  private Log logger = LogFactory.getLog(UserService.class);

  // 可重复读级别
  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public void getCount() {
    // 这里注意由于缓存的存在,导致结果的不真实,  所以可以改变查询的方向来判断结果的正确性
    List<User> users = userMapper.selectAll();
    logger.warn("初始大小: " + users.size());
    try {
      Thread.sleep(10000);
      System.out.println();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 增加了查询缓存?
    List<User> users2 = userMapper.selectAllOrderByPassword();
    logger.warn("插入数据后的大小: " + users2.size());
  }

  // mysql默认自动提交事务 ,那么, 因为是成功的提交,
  @Transactional
  public void insert() {
    User user = new User();
    user.setUsername("hch1");
    user.setPassword("1213");
    user.setEnabled(true);
    user.setSex(Sex.FEMALE);
    userMapper.insert(user);
    // 数据插入
    System.out.println();

  }
}
