package com.Mapper;

import com.Domain.Page.PageParams;
import com.Domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

//@test
public interface UserMapper {

    public int insert(User user);
    public User selectUser(String userName);
    public List<User> selectAll(RowBounds rowBounds);
    public List<User> selectAll();
    public List<User> selectAll(@Param("pageParams") PageParams pageParams);
    public User findOne(int id);
    public void update(User user);
    public List<User> findListByRoleId(Integer id);
    List<User> selectAllOrderByPassword();

    public List<User> selectAllWithPage(@Param("page") int page ,@Param("size") int size);
}