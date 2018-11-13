package com.Mapper;

import com.Domain.Page.PageParams;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

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
public class PagePlugins implements Interceptor {

  private Properties prop = null;
  private Integer page;
  private Integer pageSize;
  private Boolean useFlag;
  private Boolean checkFlag;


  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    // 目标对象
    StatementHandler statementHandler = getUnproxyObject(invocation);
    MetaObject metaObject = SystemMetaObject.forObject(statementHandler);

    //  取出即将要执行的sql
    String value = (String) metaObject.getValue("delegate.boundSql.sql");
    BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");

    Boolean flag = checkSelect(value);

    if (!flag) {
      return invocation.proceed();
    }
    // 获取sql 中对应的
    PageParams pageParams = getPageParams(boundSql.getParameterObject());
    // 获取分页参数,获取不到使用默认值

    Boolean checkFlag =
        pageParams ==null || pageParams.getCheckFlag() == null ? this.checkFlag : pageParams.getCheckFlag();
    Boolean useFlag =pageParams ==null || pageParams.getUseFlag() == null ? this.useFlag : pageParams.getUseFlag();
    Integer page =pageParams ==null || pageParams.getPage() == null ? this.page : pageParams.getPage();
    Integer pageSize = pageParams ==null ||pageParams.getPageSize() == null ? this.pageSize : pageParams.getPageSize();

    if (!useFlag) {
      return invocation.proceed();
    }
    // 获取总数 执行sql
    int total = getTotal(invocation, metaObject, boundSql);
    // 回填总数到分页参数里
    setTotalTpParams(pageParams, page, pageSize);
    // 检查当前页码的有效性
    CheckSql(checkFlag, total, page);

    return ChangeSql(invocation, metaObject, boundSql, page, pageSize);
  }

  private Object ChangeSql(Invocation invocation, MetaObject metaObject, BoundSql boundSql,
      Integer page, Integer pageSize)
      throws InvocationTargetException, IllegalAccessException, SQLException {
    // 获取需要执行的sql
    String sql = (String) metaObject.getValue("delegate.boundSql.sql");
    String newSql = "select * from ( ";
    String concat = newSql.concat(sql).concat(" ) as __lists limit  ? , ? ");
    metaObject.setValue("delegate.boundSql.sql", concat);
    // 预编译sql
    //  org.apache.ibatis.executor.statement.StatementHandler.prepare(java.sql.Connection,java.lang.Integer)
    PreparedStatement proceed = (PreparedStatement) invocation.proceed();
    int parameterCount = proceed.getParameterMetaData().getParameterCount();
    proceed.setInt(parameterCount - 1, (page - 1) * pageSize);
    proceed.setInt(parameterCount, pageSize);
    return proceed;
  }

  private void CheckSql(Boolean checkFlag, int totalPage, Integer page) throws Exception {
    // 需要检查
    if (checkFlag) {
      if (page > totalPage) {
        throw new Exception("当前页码无效: " + page);
      }
    }
  }

  private void setTotalTpParams(PageParams pageParams, int total, Integer pageSize) {
    if(pageParams!=null){
      pageParams.setTotal(total);
      int i = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
      pageParams.setTotalPage(i);
    }

  }

  private int getTotal(Invocation invocation, MetaObject metaObject, BoundSql boundSql)
      throws SQLException {
    // 获取参数
    MappedStatement value = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
    Configuration configuration = value.getConfiguration();
    String sql = (String) metaObject.getValue("delegate.boundSql.sql");
    // 改写为统计sql
    String newSql = "select count(1) as total  from (";
    String concat = newSql.concat(sql).concat(" ) as _total ");
    //
    int total = 0;
    PreparedStatement preparedStatement = null;
    // method:
    //public abstract java.sql.Statement org.apache.ibatis.executor.statement.StatementHandler.prepare(java.sql.Connection,java.lang.Integer)
    Connection connection = (Connection) invocation.getArgs()[0];
    try {
      preparedStatement = connection.prepareStatement(concat);
      BoundSql boundSql1 = new BoundSql(configuration, concat, boundSql.getParameterMappings(),
          boundSql.getParameterObject());
      DefaultParameterHandler defaultParameterHandler = new DefaultParameterHandler(value,
          boundSql.getParameterObject(), boundSql1);


      defaultParameterHandler.setParameters(preparedStatement);

      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        total = resultSet.getInt("total");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (preparedStatement != null) {
        preparedStatement.close();
      }
    }
    System.out.println("总条数: " + total);
    return total;

  }

  private PageParams getPageParams(Object parameterObject) {
    // 从配置文件中获取分页参数
    if (parameterObject == null) {
      return null;
    }
    /**
     * 提供分页参数的方式
     * Param , Map , 实例
     */
    if (parameterObject instanceof Map) {
      Map<String, Object> map = (Map<String, Object>) parameterObject;
      Set<Entry<String, Object>> entries = map.entrySet();
      for (Entry<String, Object> entry : entries) {
        Object value = entry.getValue();
        if (value instanceof PageParams) {
          return (PageParams) value;
        }
      }
    } else if (parameterObject instanceof PageParams) {
      return (PageParams) parameterObject;
    }
    return null;

  }


  private Boolean checkSelect(String value) {
    if (value != null) {
      // 考虑极致.
      value = value.trim().toLowerCase();
      return value.contains("select");
    }
    return false;
  }

  private StatementHandler getUnproxyObject(Invocation invocation) {
    StatementHandler target = (StatementHandler) invocation.getTarget();
    // 操作SystemMetaObject 的工具类
    MetaObject metaObject = SystemMetaObject.forObject(target);
    Object h = null;
    while (metaObject.hasGetter("h")) {
      h = metaObject.getValue("h");
    }

    if (h == null) {
      // 未有代理,
      return target;
    }
    return (StatementHandler) h;
  }

  @Override
  public Object plugin(Object target) {
    // 包装对象
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    // 从配置文件中获取参数;
    String page = properties.getProperty("page", "1");
    String pageSize = properties.getProperty("pageSize", "5");
    String useFlag = properties.getProperty("useFlag", "true");
    String checkFlag = properties.getProperty("checkFlag", "true");

    this.page = Integer.parseInt(page);
    this.pageSize = Integer.parseInt(pageSize);
    this.useFlag = Boolean.parseBoolean(useFlag);
    this.checkFlag = Boolean.parseBoolean(checkFlag);
    this.prop = properties;
  }
}
