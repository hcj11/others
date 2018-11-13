package com.mshuoke.datagw.domain.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-5-4
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "import_log")
public class ImportLog extends AbstractAuditingEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 文件编号
  @Column(name = "serial_no", length = 20, nullable = false, unique = true)
  private String serialno;

  //  统计记录 是否成功 0 成功 ,1 失败
  @Column(columnDefinition = "int")
  private Integer flag = 0;

  @Column(columnDefinition = "int", name = "line")
  private Integer lines = 0;

  @Column(name = "success_lines", columnDefinition = "int")
  private Integer successLines = 0;

  @Column(name = "fail_lines", columnDefinition = "int")
  private Integer failLines = 0;
  // 完全重复,重复数据
  @Column(name = "true_repeats", columnDefinition = "int")
  private Integer trueRepeats = 0;
  // 数据更新
  @Column(name = "self_repeats", columnDefinition = "int")
  private Integer selfRepeats = 0;
  // 导入失败 (自身数据重复)
  @Column(name = "fail_repeats", columnDefinition = "int")
  private Integer failRepeats = 0;
  //        'DS接收平台数据的开始时间'  在参数解析时拦截记录信息
  @Column(name = "ds_recv_begin_time")
  private Long dsRecvBeginTime;
  //        'DS接收平台数据的结束时间'
  @Column(name = "ds_recv_end_time")
  private Long dsRecvEndTime;
  //        'DS处理开始时间'
  @Column(name = "ds_process_begin_time")
  private Long dsProcessBeginTime;
  //        'DS处理结束时间'
  @Column(name = "ds_process_end_time")
  private Long dsProcessEndTime;
  // 数据备份位置记录
  @Column(name = "data_backup_log")
  private String dataBackupLog;

}
