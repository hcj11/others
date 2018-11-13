package com.Mapper;

import java.util.List;
import com.Domain.*;

@test
public interface UserMapper {

    public void insert(User user);
    public User selectUser(String userName);
    public List<User> selectAll();
}