package com.Service;

import com.Domain.Sex;
import com.Domain.User;
import com.Mapper.UserMapper;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * cglib 代理 Created by hcj on 18-7-16
 */
@Service
public class UserService {

  @Autowired
  ApplicationContext context;

  @Autowired
  private UserMapper userMapper;
  private Log logger = LogFactory.getLog(UserService.class);

  // 脏读 , 默认是 mysql的默认级别,重复读 ,出现幻读
  // 未锁住整个数据库, 事务提交没有问题,
  @Transactional(propagation = Propagation.REQUIRED)
  public void insert() throws Exception {
    User user = new User();
    user.setUsername("hch1");
    user.setPassword("1213");
    user.setEnabled(true);
    user.setSex(Sex.FEMALE);
    // 插入成功数量
    int insert = userMapper.insert(user);
    System.out.println(insert);
    // 不会回滚
//    try {
//      Thread.sleep(20000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    throw new RuntimeException("1");
  }
  // 脏读 肯定是读取重新问题了

  /**
   * READ_COMMITTED  :  读写提交,可以防止脏读的发生, 会出现事务前后数据不一致的问题 READ_UNCOMMITTED : 脏读 REPEATABLE_READ: 可重复读,
   * 可以防止读写提交出问题
   */
  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public void insertAndRead() {
    logger.info("窃取的大小: " + userMapper.selectAll().size());
  }

  // 不开启事务 @Transactional  开 与 不开
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public List<User> findUser() {
//    SqlSessionFactory sqlSessionFactory = context
//        .getBean("sqlSessionFactory", SqlSessionFactory.class);
//    Configuration configuration = sqlSessionFactory.getConfiguration();
//    System.out.println(configuration);

//    RequestContextHolder.getRequestAttributes();
    List<User> users = userMapper.selectAll();
//    logger.info("返回内容: " + users);
    return users;
  }

  // new
  public void insertBatch() {
    // cache  sqlSessionFactory 独一份
    SqlSessionFactory sqlSessionFactory = context
        .getBean("sqlSessionFactory", SqlSessionFactory.class);

    SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    // 批量插入 -> 若主键自增,就会报错,
    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setUsername("pop" + i);
      user.setPassword(i + "");
      user.setEnabled(true);
      if (i % 2 == 0) {
        user.setSex(Sex.FEMALE);
      } else {
        user.setSex(Sex.MALE);
      }
      mapper.insert(user);
      sqlSession.flushStatements();
    }
    List<User> users = mapper.selectAll();
    System.out.println(users.size());
  }

  public User findOne(Integer id) {
    return  userMapper.findOne(id);
  }

  @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
  public void update(User user) {
      userMapper.update(user);
      // 比如是否 保存到 redis上
//      throw new RuntimeException("");
  }

//  @Transactional(isolation = Isolation.REPEATABLE_READ)
//  public void insertAndRead() {
//    logger.info("窃取的大小: " + userMapper.selectAll().size());
//  }


}
