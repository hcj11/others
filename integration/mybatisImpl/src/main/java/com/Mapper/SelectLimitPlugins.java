package com.Mapper;

import java.sql.Connection;
import java.util.Properties;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * Created by hcj on 18-7-19
 */
@Intercepts({
    @Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class}
    )
}
)
public class SelectLimitPlugins implements Interceptor {

  Properties prop = null;
  private final static String limit_table = "xxx_limit_table_users";
  private int limit = 1;


  @Override
  public Object intercept(Invocation invocation) throws Throwable {

    // 返回目标对象
    StatementHandler target = (StatementHandler) invocation.getTarget();
    // 操作SystemMetaObject 的工具类
    MetaObject metaObject = SystemMetaObject.forObject(target);
    while (metaObject.hasGetter("h")) {
      Object h = metaObject.getValue("h");
      metaObject = SystemMetaObject.forObject(h);
    }
    // 直到解析到最后一层
    while (metaObject.hasGetter("target")) {
      Object h = metaObject.getValue("target");
      metaObject = SystemMetaObject.forObject(h);
    }
    // 取出即将要执行的sql
    String value = (String) metaObject.getValue("delegate.boundSql.sql");
    String newSql = "select * from (";
    // 只对哪一张的表的拦截设置
    if (value != null && !value.contains(limit_table) && value.contains("select")) {
      String concat = newSql.concat(value).concat(" ) limit_table limit  ")
          .concat(this.limit + " ");
      metaObject.setValue("delegate.boundSql.sql", concat);
    }
    Object proceed = invocation.proceed();

    return proceed;
  }

  @Override
  public Object plugin(Object target) {
    // 包装对象
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    // 从配置文件中获取参数;
    //    Integer dbType = (Integer) properties.get("dbType");
//    System.out.println(String.valueOf(dbType));
    String limit = properties.getProperty("limit", "1");
    this.limit = Integer.parseInt(limit);
    this.prop = properties;
  }
}
