package com.Mapper;

import java.util.Properties;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * Created by hcj on 18-7-19
 */
@Intercepts({
    @Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
    )
}
)
public class MyPlugins implements Interceptor {
  Properties prop=null;
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    System.out.println("********************方法拦截前");
    // 返回目标对象
    Object proceed = invocation.proceed();
    System.out.println("********************方法拦截后");
    return proceed;
  }

  @Override
  public Object plugin(Object target) {
    // 包装对象
    return Plugin.wrap(target,this);
  }

  @Override
  public void setProperties(Properties properties) {
    // 从配置文件中获取参数
    Object dbType = properties.get("dbType");
    System.out.println(String.valueOf(dbType));
    this.prop=properties;
  }
}
