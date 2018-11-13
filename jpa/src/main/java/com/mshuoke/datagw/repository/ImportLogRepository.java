package com.mshuoke.datagw.repository;


import com.mshuoke.datagw.domain.pojo.ImportLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hcj on 18-5-4
 */
public interface ImportLogRepository extends JpaRepository<ImportLog,Long> {
  // 导入记录
}
