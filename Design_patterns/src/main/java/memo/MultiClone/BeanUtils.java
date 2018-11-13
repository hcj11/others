package memo.MultiClone;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by hcj on 18-7-8
 */
public class BeanUtils {

  static HashMap<String, Object> backupProp(Object bean) {
    // 备份数据
    HashMap<String, Object> map = new HashMap<>();
    try {
      BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
      PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
      for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
        String name = propertyDescriptor.getName();
        Method readMethod = propertyDescriptor.getReadMethod();
        // 读取属性值
        Object fieldValue = readMethod.invoke(bean, new Object[]{});
        // 不要类名
        if (!name.equalsIgnoreCase("class")) {
          map.put(name, fieldValue);
        }

      }
    } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
    return map;
  }

  static void restoreProp(Object bean, HashMap<String, Object> map) {
    // 根据map,恢复bean
    try {
      BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
      PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
      for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
        String name = propertyDescriptor.getName();
        // 读取属性值
        // 不要类名
        if (map.containsKey(name)) {
          Method setter = propertyDescriptor.getWriteMethod();
          // 设置方法参数
          setter.invoke(bean, new Object[]{map.get(name)});
        }

      }
    } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }

}
