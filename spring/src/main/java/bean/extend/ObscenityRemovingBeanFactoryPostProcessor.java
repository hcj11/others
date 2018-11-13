package bean.extend;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

/**
 * Created by hcj on 18-7-14
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  // 对初始化数据的拦截处理
  private Set<String> obsences;
  public  ObscenityRemovingBeanFactoryPostProcessor(){
    this.obsences=new HashSet<>();
  }
  // set ->
  public void setObsences(Set<String> obsences) {
    // 先清库,防止意外添加
    this.obsences.clear();
    for (String ss : obsences) {
      this.obsences.add(ss.toUpperCase());
    }
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    // 对每个bean进行拦截
    String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
    for (String s : beanDefinitionNames) {
      BeanDefinition beanDefinition = beanFactory.getBeanDefinition(s);
      StringValueResolver stringValueResolver = new StringValueResolver() {
        @Override
        public String resolveStringValue(String strVal) {
          if (isObsence(strVal)) {
            return  "******";
          }
          // 非淫秽数据 放过.
          return strVal;
        }
      };
      BeanDefinitionVisitor beanDefinitionVisitor = new BeanDefinitionVisitor(stringValueResolver);
      beanDefinitionVisitor.visitBeanDefinition(beanDefinition);
    }

  }

  public boolean isObsence(String str) {
    return this.obsences.contains(str.toUpperCase());
  }


}
