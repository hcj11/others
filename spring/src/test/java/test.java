import static bean.FactoryGenerate.newInstance;
import static bean.InitBeanImpl.InitBeanImpl.getAa;
import static org.springframework.beans.factory.xml.BeanDefinitionParserDelegate.MULTI_VALUE_ATTRIBUTE_DELIMITERS;

import bean.AwareHello.AwareHelloBeanClassLoader;
import bean.AwareHello.AwareHelloBeanFactory;
import bean.Circle.TestA;
import bean.FactoryGenerate;
import bean.InitBeanImpl.InitBeanImpl;
import bean.Listener.TestEvent;
import bean.MyTestBean;
import bean.Student;
import bean.Teacher;
import bean.User;
import bean.beanPostProcessor.MyBeanPostProcessor;
import bean.extend.MyClassPathXmlApplication;
import bean.extend.SimpleBean;
import java.lang.annotation.Documented;
import java.net.URISyntaxException;
import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.BeanMetadataAttributeAccessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

/**
 * Created by hcj on 18-7-13
 */
public class test {
//  @Autowired
//  User user;
//  @Autowired
//  public Student getTestBean(@Qualifier Student student){
//    return student;
//  }
  @Test
  public void myBeanPostProcessor(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
    ConfigurableListableBeanFactory configurableListableBeanFactory = new XmlBeanFactory(new ClassPathResource("testBean.xml"));
    // 加载BeanFactoryPostProcessor
    BeanFactoryPostProcessor obscenityRemovingBeanFactoryPostProcessor = (BeanFactoryPostProcessor) configurableListableBeanFactory
        .getBean("obscenityRemovingBeanFactoryPostProcessor");
    // obscenityRemovingBeanFactoryPostProcessor 注册处理configurableListableBeanFactory 信息
    Student student = classPathXmlApplicationContext.getBean("student", Student.class);
    student.getname();


  }
  @Test
  public void customBeanFactoryPostProcessor(){
    ConfigurableListableBeanFactory configurableListableBeanFactory = new XmlBeanFactory(new ClassPathResource("testBean.xml"));
    // 加载BeanFactoryPostProcessor
    BeanFactoryPostProcessor obscenityRemovingBeanFactoryPostProcessor = (BeanFactoryPostProcessor) configurableListableBeanFactory
        .getBean("obscenityRemovingBeanFactoryPostProcessor");
    // obscenityRemovingBeanFactoryPostProcessor 注册处理configurableListableBeanFactory 信息
    obscenityRemovingBeanFactoryPostProcessor.postProcessBeanFactory(configurableListableBeanFactory);
    MyBeanPostProcessor myBeanPostProcessor = configurableListableBeanFactory
        .getBean("myBeanPostProcessor", MyBeanPostProcessor.class);
    // 添加自定义处理器,
    configurableListableBeanFactory.addBeanPostProcessor(myBeanPostProcessor);
    System.out.println(configurableListableBeanFactory.getBean("simpleBean",SimpleBean.class));
  }

  @Test
  public void myClassPathConfig(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new MyClassPathXmlApplication(
        "testBean.xml");
    Student student = classPathXmlApplicationContext.getBean("student", Student.class);
    student.getname();


  }

  @Test
  public void initBeanTest(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "testBean.xml");

    InitBeanImpl initBeanImpl = classPathXmlApplicationContext
        .getBean("initBeanImpl", InitBeanImpl.class);
    System.out.println(getAa());

  }

  @Test
  public void awareTest(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "testBean.xml");
//    AwareHelloBeanFactory awareHelloBeanFactory = classPathXmlApplicationContext
//        .getBean("awareHelloBeanFactory", AwareHelloBeanFactory.class);
//    awareHelloBeanFactory.testHello();
    AwareHelloBeanClassLoader awareHelloBeanFactory = classPathXmlApplicationContext
        .getBean("awareHelloBeanClassLoader", AwareHelloBeanClassLoader.class);

  }
  @Test
  public void factory(){
    // factory-method
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "testBean.xml");
    // 不允许循环依赖
//    classPathXmlApplicationContext.setAllowCircularReferences(false);
    TestA factory = (TestA) classPathXmlApplicationContext.getBean("factory");

    System.out.println(factory.hashCode());

  }
  @Test
  public void test(){
//    CollectionUtils.mergeArrayIntoCollection();
//    CollectionUtils.mergePropertiesIntoMap();
    try {
      // url and uri 的区别
      boolean absolute = ResourceUtils.toURI("file://home/hcj/模板/upload_template.xlsx").isAbsolute();
      System.out.println(absolute);
      boolean url = ResourcePatternUtils.isUrl("classpath:testBean.xml");
      System.out.println(url);

    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

  }
  @Test
  public void loadWithQualify(){
//    System.out.println(myTestBean.getStrTest());;
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "testBean.xml");
    // 别名取值.
    Teacher testBean =(Teacher) classPathXmlApplicationContext.getBean("hhh");
    testBean.getname();
    // 如何扫描config
    Student testBean2 =(Student) classPathXmlApplicationContext.getBean("student");
    testBean2.getname();
  }


  @Test
  public void load(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
        "testBean.xml");
    MyTestBean testBean =(MyTestBean) classPathXmlApplicationContext.getBean("testBean");
//    System.out.println(testBean.getId());
    // 应该是初始化后加载使用到
    RootBeanDefinition beanMetadataAttributeAccessor = new RootBeanDefinition();
    String metatest = (String) beanMetadataAttributeAccessor.getAttribute("metatest");
    System.out.println(metatest);

  }
  @Test
  public void demo2(){
    // , 分隔
    String aaa="1,2,3";
    String[] strings = StringUtils.commaDelimitedListToStringArray(aaa);
    System.out.println(strings);

//    PatternMatchUtils.simpleMatch(patterns,beansname);

//    String nameAttr="testBean,dd dsad;dasd";
//    String[] nameArr = StringUtils
//        .tokenizeToStringArray(nameAttr, MULTI_VALUE_ATTRIBUTE_DELIMITERS);
//    System.out.println(nameArr);
  }

  @Test
  public void demo(){
  String content="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
      + "<beans xmlns=\"http://www.springframework.org/schema/beans\"\n"
      + "  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
      + "  xmlns:context=\"http://www.springframework.org/schema/context\"\n"
      + "  xmlns:c=\"http://www.springframework.org/schema/c\"\n"
      + "  xmlns:p=\"http://www.springframework.org/schema/p\"\n"
      + "  xsi:schemaLocation=\"http://www.springframework.org/schema/beans\n"
      + "  http://www.springframework.org/schema/beans/spring-beans.xsd\n"
      + "\t\thttp://www.springframework.org/schema/context\n"
      + "\t\thttp://www.springframework.org/schema/context/spring-context.xsd\">\n"
      + "\n"
      + "  <bean name=\"testBean\" class=\"bean.MyTestBean\">\n"
      + "\n"
      + "  </bean>\n"
      + "</beans>";
    int openTagIndex = content.indexOf("<");
    boolean letter = Character.isLetter(content.charAt(openTagIndex + 1));
    System.out.println(letter);

  }
    @Test
    public void create(){
      // 加载bean
      XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("testBean.xml"));

      MyTestBean testBean = (MyTestBean) xmlBeanFactory.getBean("testBean");
      System.out.println(testBean.getStrTest());
      ClassPathResource classPathResource = new ClassPathResource("testBean.xml");
      // 加载inputStream 资源 ,可以进行读取处理
      String description = classPathResource.getDescription();
      System.out.println(description);
//      classPathResource.getInputStream();


    }
}
