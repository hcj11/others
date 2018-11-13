package spittr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import spittr.config.MailServerProperties;

/**
 * Created by hcj on 18-3-7
 */

@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
@EnableConfigurationProperties({MailServerProperties.class})
public class CerberusApplication {


  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(CerberusApplication.class);
    app.run(args);
  }

}

