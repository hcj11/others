package com.Config;

import java.sql.CallableStatement;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

/**
 * Created by hcj on 18-7-18
 */
@MappedTypes({String.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeHandler implements TypeHandler<String> {

  @Override
  public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
      throws SQLException {
    System.out.println("自定义类型转换");
    ps.setString(i, parameter);
  }

  @Override
  public String getResult(ResultSet rs, String columnName) throws SQLException {
    System.out.println("自定义类型转换");
    return rs.getString(columnName);
  }

  @Override
  public String getResult(ResultSet rs, int columnIndex) throws SQLException {
    System.out.println("自定义类型转换");
    return rs.getString(columnIndex);
  }

  @Override
  public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
    System.out.println("自定义类型转换");
    return cs.getString(columnIndex);
  }
}
