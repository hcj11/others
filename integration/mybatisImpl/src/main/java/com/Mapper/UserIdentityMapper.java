package com.Mapper;

import com.Domain.UserIdentity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by hcj on 18-7-18
 */
@Mapper
public interface UserIdentityMapper {
  public UserIdentity findOne(Integer id);
  public List<UserIdentity> findAll();
  public void putObject(UserIdentity userIdentity);
  public void update(UserIdentity userIdentity);
}
