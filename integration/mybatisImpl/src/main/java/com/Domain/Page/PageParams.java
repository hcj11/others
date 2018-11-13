package com.Domain.Page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页插件的作用就是
 * Created by hcj on 18-7-19
 */
@Setter
@Getter
@ToString
public class PageParams  {
    private Integer pageSize;
    // 当前页
    private Integer page;
    // 开启分页
    private Boolean useFlag;
    // 检查当前页码的有效性
    private Boolean checkFlag;
    // 总数
    private Integer total;
    // 总页数
    private Integer totalPage;

}
