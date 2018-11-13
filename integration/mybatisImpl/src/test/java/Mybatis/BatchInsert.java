package Mybatis;

import com.Domain.UserInsert;
import com.Mapper.UserInsertMapper;
import com.Service.Cache.RedisCacheService;
import com.StartUp;
import com.mysql.cj.api.jdbc.JdbcConnection;
import com.redis.redisTemplate.HashUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by hcj on 18-7-27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StartUp.class})
public class BatchInsert {

//  private static final AnnotationConfigApplicationContext context =
//      new AnnotationConfigApplicationContext(StartUp.class);
  @Autowired
  ApplicationContext context;

  @Autowired
  HashUtil hashUtil;

  @Test
  public void testRedis() {
//    HashUtil bean = context.getBean("hashUtil", HashUtil.class);
//    System.out.println(bean.getRedisTemplateY());
//    hashUtil.getHashOperationsY().put("hash_1:","1","123");

    RedisCacheService redisCacheService = context
        .getBean("redisCacheService", RedisCacheService.class);

    redisCacheService.putObject("1","2");

  }

//  @Test
//  public void batchTest() {
//
//    SqlSessionFactory sqlSessionFactory = context
//        .getBean("sqlSessionFactory", SqlSessionFactory.class);
//    //
//    sqlSessionFactory.openSession(ExecutorType.SIMPLE, TransactionIsolationLevel.READ_COMMITTED);
//    SqlSession sqlSession = sqlSessionFactory.openSession();
//
//    UserInsertMapper mapper = sqlSession.getMapper(UserInsertMapper.class);
//    // 批量插入 -> 若主键自增,就会报错,
//    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//    String encode = bCryptPasswordEncoder.encode("123");
//    for (int i =7047; i < 100000; i++) {
//      UserInsert user = new UserInsert();
//      user.setLogin("login-"+i);
//      user.setFirstName("哈哈"+i);
//      user.setLastName("呵呵"+i);
//      user.setPassword(encode);
//      user.setRoleId(1L);
//      user.setCreate_by("login-"+i);
//      mapper.insert(user);
//    }
//    // 内存？ 刷新
//    sqlSession.flushStatements();
//  }

//  @Test
//  public void commonJdbcTest(){
//    //第一步：加载MySQL的JDBC的驱动
//    Class.forName(driver_class);
//    //第二步：创建与MySQL数据库的连接类的实例
//    Connection con = (Connection) DriverManager.getConnection(url, username, password);
//    Statement statement = con.createStatement();
//
//    ResultSet resultSet = statement.executeQuery("");
//
//
////    PreparedStatement preparedStatement = con.prepareStatement("");
////    ResultSet resultSet1 = preparedStatement.executeQuery();
//
//
//    while(resultSet.next()){
//      resultSet.getString("");
//    }
//
//  }
}
