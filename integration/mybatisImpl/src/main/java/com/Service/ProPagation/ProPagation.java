package com.Service.ProPagation;

import com.Domain.User;
import com.Domain.UserIdentity;
import com.Mapper.UserIdentityMapper;
import com.Mapper.UserMapper;
import com.Service.UserService;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 传播行为 Created by hcj on 18-7-17
 */
@Service
public class ProPagation {

  @Autowired
  UserMapper userMapper;
  @Autowired
  UserIdentityMapper userIdentityMapper;

  @Autowired
  ProPagationSample proPagationSample;
  private Log logger = LogFactory.getLog(UserService.class);

  // 可重复读级别
  @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
  public void insert() {
    System.out.println();
    // 这里注意由于缓存的存在,导致结果的不真实,  所以可以改变查询的方向来判断结果的正确性
    List<User> users = userMapper.selectAll();
    logger.warn("初始大小: " + users.size());
    // lock 挂起尝试,
    UserIdentity user = new UserIdentity();
    user.setAddress("had");
    userIdentityMapper.putObject(user);

    // 建立保存点?,并回滚到保存点出?
//    try {
      for (int i = 0; i < 10; i++) {
        proPagationSample.insert(i);
      }
//    } catch (Exception e) {
//      // 判读是否回滚 ,那么 主事务可以不回滚
//      e.printStackTrace();
//    }

    // 若在一个事务中出现了异常,需要回滚, 会出现在出错之前的查询增加的情况, 和之前的查询不一致的情况,所以在编码的情况
    // 这笔交易不会成功, 就因为出现异常, 事务会进行回滚
    List<User> users1 = userMapper.selectAll();
    logger.warn("初始大小: " + users1.size());
//    int i = 1 / 0;
  }


  @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
  public void getCount() {
//    try {
//      Thread.sleep(10000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    // 将此事务挂起
//    List<User> users2 = userMapper.selectAllOrderByPassword();
//    logger.warn("插入数据后的大小: " + users2.size());
    // readOnly = true -> 对于这种情况,  数据是不能进行插入的,否则会报错

    // 父事务正常提交操作. 若是 REQUIRES_NEW 则整个事务都有回滚,
    // 若是 NESTED 则若父事务报错,子事务也会受影响,
    // 子事务出错,那么父事务也要回滚,
    User user = new User();
    user.setUsername("hch1");
    user.setPassword("123d");
    user.setEnabled(true);
    userMapper.insert(user);

    for (int i = 0; i < 6; i++) {
      proPagationSample.insert(i);
    }
    int i = 1 / 0;

//    User user = new User();
//    user.setUsername("hch1");
//    user.setPassword("123d");
//    user.setEnabled(true);
    //  Propagation.NESTED 内嵌传播, 对于父传播,

  }


}
