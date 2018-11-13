package com.Controller;

import com.Domain.UserIdentity;
import com.Mapper.UserIdentityMapper;
import com.Service.Cache.RedisCacheService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcj on 18-7-18
 */
@RestController
@RequestMapping("userIdentity")
public class UserIndentityController {

  @Autowired
  UserIdentityMapper userIdentityMapper;
//  @Autowired
//  RedisCacheService service;
  // 开启 <cache> 后, 使用的是二级缓存, 可以跨sqlSession使用.
  // 即通过Mapper的第一次之后的查询会从缓存pa 汇总获取

  @GetMapping
  public ResponseEntity<List<UserIdentity>> getAll(@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize){
    //
    HashMap<Object, Object> map = new HashMap<>();
    Page<Object> objects = PageHelper.startPage(page, pageSize,true);
    map.put("list",userIdentityMapper.findAll());
    map.put("page",objects.getResult());
    System.out.println(objects);

    return ResponseEntity.ok(null);
  }

  @GetMapping("{id}")
  public ResponseEntity<UserIdentity> getCache(@PathVariable(value = "id")Integer id) {
    // 若是list , 应该就是list + map list<多个个元素>   object -> 无非就是list<1个元素>

    UserIdentity one = userIdentityMapper.findOne(id);
    // 对于同一个mapper开启二级缓存后使用同一个sqlSession
//    Cache Hit Ratio [com.Mapper.UserIdentityMapper]: 0.5
//    UserIdentity one1 = userIdentityMapper.findOne(1);
    // 二级 缓存
    return ResponseEntity.ok(one);
  }

  @PutMapping("{id}")
  public void update(@PathVariable("id")Integer id , @RequestBody UserIdentity userIdentity){
    userIdentity.setId(id);
    userIdentityMapper.update(userIdentity);
  }

//  @GetMapping("redis")
//  public ResponseEntity<String> getRedis() {
//    service.putObject("1","2");
////    UserIdentity one = userIdentityMapper.findOne(1);
//    // 对于同一个mapper开启二级缓存后使用同一个sqlSession
////    Cache Hit Ratio [com.Mapper.UserIdentityMapper]: 0.5
////    UserIdentity one1 = userIdentityMapper.findOne(1);
//    // 二级 缓存
//    return ResponseEntity.ok("123");
//  }

  @GetMapping("string")
//  @ResponseBody
  public ResponseEntity<UserIdentity> get() {
//    UserIdentity one = userIdentityMapper.findOne(1);
    UserIdentity userIdentity = new UserIdentity();
    userIdentity.setAddress("123");
    // 对于同一个mapper开启二级缓存后使用同一个sqlSession
//    Cache Hit Ratio [com.Mapper.UserIdentityMapper]: 0.5
//    UserIdentity one1 = userIdentityMapper.findOne(1);
    // 二级 缓存
    return ResponseEntity.ok(userIdentity);
  }

  @PostMapping
  public void putObject(@RequestBody UserIdentity userIdentity){
    userIdentityMapper.putObject(userIdentity);
  }



}
