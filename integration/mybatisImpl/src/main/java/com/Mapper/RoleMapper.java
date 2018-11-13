package com.Mapper;

import com.Domain.Role;
import com.Domain.User;
import java.util.List;

/**
 * Created by hcj on 18-7-18
 */
public interface RoleMapper {
  public List<Role> findUserList(Integer id);
}
