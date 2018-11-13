package Mybatis;

import com.Domain.Goods;
import com.Mapper.GoodsMapper;
import com.Service.Cache.RedisCacheService;
import com.StartUp;
import com.redis.redisTemplate.HashUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hcj on 18-7-27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StartUp.class})
public class OpermissLockTest {

  @Autowired
  ApplicationContext context;

  @Test
  public void test(){
    GoodsMapper bean = context.getBean(GoodsMapper.class);
//    bean.insert(new Goods("商品1",10,0));
//    bean.insert(new Goods("商品2",10,0));

    int update = bean.update(1, "商品1-1", 0);
    System.out.println("修改商品信息1"+(update==1?"成功":"失败"));
    int update1 = bean.update(1, "商品1-2", 0);
    System.out.println("修改商品信息2"+(update1==1?"成功":"失败"));
    // 乐观锁重试。
//    if(update1!=1){
//      while (update1<3)
//        bean.update(1, "商品1-2", 0);
//
//    }

  }



}
