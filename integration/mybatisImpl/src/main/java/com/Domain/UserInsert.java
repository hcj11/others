package com.Domain;

import java.io.Serializable;
import java.time.Instant;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by hcj on 18-7-27
 */
@Setter
@Getter
@ToString
public class UserInsert implements Serializable {
  private Long id;
  private String login;
  private String password;
  private String firstName;
  private String lastName;
  private Long roleId;
  private String create_by;
  private Instant create_date = Instant.now();

}
