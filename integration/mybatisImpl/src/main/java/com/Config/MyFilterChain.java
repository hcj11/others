package com.Config;

import com.Domain.User;
import com.Service.UserService;
import com.sun.glass.ui.Application;
import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by hcj on 18-7-20
 */

//@WebFilter(filterName = "testFilter1", urlPatterns = "/*")
public class MyFilterChain implements Filter {
  @Autowired
  ApplicationContext context;

//  @Autowired
//  ServletContext servletContext;

  @Override
  public void init(FilterConfig filterConfig)  {
  // 两次初始化.
    System.out.println("初始化,");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // 添加到过滤链中,
    System.out.println("哈哈");
    chain.doFilter(request, response);

  }

  @Override
  public void destroy() {
//    UserService userService = context.getBean("userService", UserService.class);
//    List<User> user = userService.findUser();
//    System.out.println(user);
    // servlert 容器关闭时执行
    System.out.println("结束,");
  }
}
