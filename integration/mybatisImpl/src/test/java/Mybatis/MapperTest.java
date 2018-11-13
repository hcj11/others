package Mybatis;

import com.Config.AppConfig1;
import com.Domain.Page.PageParams;
import com.Domain.Role;
import com.Domain.Sex;
import com.Domain.User;
import com.Domain.UserIdentity;
import com.Mapper.RoleMapper;
import com.Mapper.UserIdentityMapper;
import com.Mapper.UserMapper;
import java.io.IOException;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hcj on 18-7-18
 */
@RunWith(SpringRunner.class)
public class MapperTest {

  private static final AnnotationConfigApplicationContext context =
      new AnnotationConfigApplicationContext(AppConfig1.class);

  @Test
  public void build() {
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    try {
      // this.getClass().getClassLoader() 当前类加载器加载
      SqlSessionFactory build = builder.build(
          Resources.getResourceAsStream(this.getClass().getClassLoader(), "sqlMapConfig.xml"));
      Configuration configuration = build.getConfiguration();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void putObject() {
    SqlSessionFactory sqlSessionFactory = context
        .getBean("sqlSessionFactory", SqlSessionFactory.class);
    SqlSession sqlSession2 = sqlSessionFactory.openSession();
    UserIdentityMapper mapper2 = sqlSession2.getMapper(UserIdentityMapper.class);
    UserIdentity userIdentity = new UserIdentity();
    userIdentity.setAddress("哈");
    mapper2.putObject(userIdentity);
  }

  @Test
  public void batchTest(){

    SqlSessionFactory sqlSessionFactory = context
        .getBean("sqlSessionFactory", SqlSessionFactory.class);
    // sqlSession 开启事务。 ExecutorType.REUSE   保证batch 事务的合理使用，
    SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE,TransactionIsolationLevel.READ_COMMITTED);
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    // 批量插入 -> 若主键自增,就会报错,
    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setUsername("pop" + i);
      user.setPassword(i + "");
      user.setEnabled(true);
      if(i % 2 ==0){
        user.setSex(Sex.FEMALE);
      }else{
        user.setSex(Sex.MALE);
      }
      if(i==8){
        int ii=1/0;
      }
      mapper.insert(user);

    }
    // 刷新
    sqlSession.flushStatements();
//    List<User> users = mapper.selectAll();
//    System.out.println(users.size());

  }

  @Test
  public void getIdentity() {
    SqlSessionFactory sqlSessionFactory = context
        .getBean("sqlSessionFactory", SqlSessionFactory.class);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserIdentityMapper mapper = sqlSession.getMapper(UserIdentityMapper.class);
    UserIdentity one1 = mapper.findOne(1);
    System.out.println(one1);
    // 二级缓存 测试缓存?.
    SqlSession sqlSession2 = sqlSessionFactory.openSession();
    UserIdentityMapper mapper2 = sqlSession2.getMapper(UserIdentityMapper.class);
    UserIdentity one2 = mapper2.findOne(1);
    System.out.println(one2);
    // 开启二级缓存

  }

  @Test
  public void assocation() {
    // 关联查询,一对一
    UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
    User one1 = userMapper.findOne(1);
    User one2 = userMapper.findOne(1);
//    String address = one.getUserIdentity().getAddress();
//    System.out.println(one.getMaleHealths());
//    System.out.println(one.getFeMaleHealths());
//    System.out.println(address);

  }

  @Test
  public void collection() {
    // 关联查询,一对多, -> 1对1,
    RoleMapper roleMapper = context.getBean("roleMapper", RoleMapper.class);
    List<Role> userList = roleMapper.findUserList(1);
    for (Role role : userList) {
      // 注意此处,不要打断点看  ,因为看断点会触发sql的级联查询的.
      List<User> userList1 = role.getUserList();
      for (User user : userList1) {
        // lazy and eager 的使用,
        System.out.println(user.getId());

      }
//       toString 会一直向下遍历元素的
//      System.out.println(user.getUserList())
 ;
    }
  }

  @Test
  public void insert() {
    UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setUsername("pop" + i);
      user.setPassword(i + "");
      user.setEnabled(true);
      if(i % 2 ==0){

        user.setSex(Sex.FEMALE);
      }else{
        user.setSex(Sex.MALE);
      }
      userMapper.insert(user);
    }
  }

  @Test
  public void update() {
    UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
    User user = new User();
    user.setUsername("pop");
    user.setId(1);
    userMapper.update(user);
  }

  @Test
  public void selectAllWithPagePlugins() {
    UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
    PageParams pageParams = new PageParams();
    pageParams.setPage(2);
    pageParams.setPageSize(4);
    List<User> users = userMapper.selectAll(pageParams);
    for(User user:users){
      System.out.println(user.getId());
    }
    System.out.println(pageParams);
  }

  @Test
  public void selectAll() {
    UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
    List<User> users = userMapper.selectAll(new RowBounds(0,5));
    System.out.println(users.size());
  }

  @Test
  public void selectAllWithPage() {
    // 若不写插件的话,  可以直接原生sql,不过每个方法都要先查询count,才能确定页大小,
    UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
    List<User> users = userMapper.selectAllWithPage(10,10);
    System.out.println(users.size());

  }


}
