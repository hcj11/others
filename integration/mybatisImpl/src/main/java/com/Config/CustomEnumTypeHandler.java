package com.Config;

import com.Domain.Sex;
import java.sql.CallableStatement;
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
@MappedTypes({Sex.class})
@MappedJdbcTypes(JdbcType.INTEGER)
public class CustomEnumTypeHandler implements TypeHandler<Sex> {

  @Override
  public void setParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType)
      throws SQLException {
    // i <-> enum
    System.out.println("自定义类型转换");
    ps.setInt(i, parameter.getSex());
  }

  @Override
  public Sex getResult(ResultSet rs, String columnName) throws SQLException {
    int anInt = rs.getInt(columnName);
    if(anInt==0){
      return Sex.FEMALE;
    }else{
      return Sex.MALE;
    }
  }

  @Override
  public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
    return (Sex) rs.getObject(columnIndex);
  }

  @Override
  public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return (Sex) cs.getObject(columnIndex);
  }

}
