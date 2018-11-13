package com.mshuoke.datagw.Service;

import com.mshuoke.datagw.domain.pojo.ImportLog;
import com.mshuoke.datagw.repository.ImportLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hcj on 18-7-16
 */
@Service
public class ImportLogService {

  @Autowired
  ImportLogRepository importLogRepository;

  @Transactional
  public void insert() {
    ImportLog importLog = new ImportLog();
    importLog.setFlag(1);
    importLog.setSerialno("123");
    importLogRepository.save(importLog);
    throw new RuntimeException("a");
  }

  public long select() {
    return importLogRepository.count();
  }
}
