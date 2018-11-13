package com.Domain;

import lombok.Data;
import org.springframework.data.annotation.Version;

import java.io.Serializable;

/**
 *  商品库存
 *  Create by houchunjian on 2018/10/18 0018
 */
@Data
public class Goods implements Serializable {
    public static final long serialVersionUID = 1L;

    // @Version 乐观锁，redis? 提供?
    private Integer id;
    private String name;
    // 数量
    private Integer quantity;
    private Integer version;

    public Goods(String name, Integer quantity, Integer version) {
        this.name = name;
        this.quantity = quantity;
        this.version = version;
    }
}
