package com.mshuoke.datagw.controller;//package com.mshuoke.datagw.controller;

import com.mshuoke.datagw.Service.ImportLogService;
import com.mshuoke.datagw.repository.ImportLogRepository;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcj on 18-3-7
 */
@RequestMapping("/select")
@RestController
public class SelectController {

  @Autowired
  ImportLogRepository importLogRepository;
  @Autowired
  ImportLogService importLogService;

  // 目前只支持 日期查询，参数
  @PostMapping("insert")
  public ResponseEntity insert() throws SQLException {
    // 根据登录者的信息查询对应的文件,
    importLogService.insert();
    return ResponseEntity.ok("ok");
  }

  // 目前只支持 日期查询，参数
  @GetMapping("count")
  public ResponseEntity findCount() throws SQLException {
    // 根据登录者的信息查询对应的文件,
    long count = importLogService.select();
    return ResponseEntity.ok(count);
  }


}
