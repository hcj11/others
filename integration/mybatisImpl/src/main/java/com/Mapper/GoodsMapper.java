package com.Mapper;

import com.Domain.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GoodsMapper {
    public int update(@Param("id") Integer id , @Param("name") String name, @Param("version")Integer version);
    @Select("select * from t_goods where id=#{param1}")
    public Goods selectAll(Integer id);
    public void insert(Goods goods);
}
