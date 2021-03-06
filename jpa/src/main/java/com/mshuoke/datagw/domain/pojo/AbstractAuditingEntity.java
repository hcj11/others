package com.mshuoke.datagw.domain.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Created by hcj on 18-5-4
 */
@Getter
@Setter
public abstract class AbstractAuditingEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @CreatedBy
  @Column(name = "created_by", nullable = false, length = 50, updatable = false)
  @JsonIgnore
  private String createdBy;

  @CreatedDate
  @Column(name = "created_date", nullable = false)
  @JsonIgnore
  private Instant createdDate = Instant.now();

  @LastModifiedBy
  @Column(name = "last_modified_by", length = 50)
  @JsonIgnore
  private String lastModifiedBy;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  @JsonIgnore
  private Instant lastModifiedDate = Instant.now();

}
