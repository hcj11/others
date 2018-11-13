package bean.InitBeanImpl;

import java.util.ArrayList;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by hcj on 18-7-14
 */
public class InitBeanImpl implements InitializingBean{
  private String hah;
  public InitBeanImpl(){}
  public InitBeanImpl(String hah){
    this.hah=hah;
  }
  private static ArrayList<String> aa =new ArrayList<>();
  // 当加载该bean时, 默认调用的重写方法
  // 初始化方法
  @Override
  public void afterPropertiesSet() throws Exception {
    // 初始化参数  java Config 使用试试,搭建springmvc 试试
    aa.add(this.hah);
  }

  public static ArrayList<String> getAa() {
    return aa;
  }
}
