package com.Service.ProPagation;

import com.Domain.Sex;
import com.Domain.User;
import com.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 传播行为 Created by hcj on 18-7-17
 */
@Service
public class ProPagationSample {

  @Autowired
  UserMapper userMapper;

  // mysql默认自动提交事务 ,那么, 因为是成功的提交,
  // Propagation.REQUIRES_NEW 新开一个事务的话,就和之前的事务无关了,  原事务不会影响到该事务
  // 但是原事务会挂起，来保持该事务的执行结束，  但是若超过了原事务的等待时间，则innodb会进行重试，导致方法无法进行。
  @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
  public void insert(int i) {
    // 这里需要记录成功的条数,和id值,存储到mysql中,  待从从出错点继续进行,
//    try {
//      Thread.sleep(10);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    // 开启单独事务执行该操作 , 回滚到出错的保存点,
    User user = new User();
    // 封装参数,
    if (i == 5) {
      int j = 1 / 0;
    }
    user.setUsername("hch1");
    user.setPassword(i + "");
    user.setEnabled(true);
    user.setSex(Sex.MALE);
    userMapper.insert(user);


  }
}
