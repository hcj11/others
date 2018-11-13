package com.gc;

import java.time.Instant;
import java.util.Hashtable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Setter
@Getter
@RequestMapping("GC/")
@RestController
public class GcTestDemo {

  private final static Hashtable map = new Hashtable();

  // 构建  200万数据 ,1000万正常启动的瓶颈。-》会卡死
  @PostMapping("putData")
  public void buildMap() {
    // 200万数据  直接卡死。
    for (int i = 0; i < 2000000; i++) {

      map.put(i, new players("第" + i + "位", (i % 2 == 0), i, Instant.now()));
    }
  }

  @GetMapping("{id}")
  public ResponseEntity getData(@PathVariable("id") Integer id) {
//    System.out.println(map);
    // 随机提供一部分数据个给前台
    // 下去正
    double ceil = Math.ceil(Math.random() * 2000000);

    players player = (players) map.get(ceil);
    return ResponseEntity.ok(player);
  }

  public static void main(String[] args) {
    // 0-2000000   0, 5
    double random = Math.random();
    int ceil = (int) Math.ceil(random * 2000000);
    System.out.println(random);
    System.out.println(ceil);
  }


}
