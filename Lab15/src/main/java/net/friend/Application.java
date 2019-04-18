package net.friend;

import lombok.extern.slf4j.Slf4j;
import net.friend.service.MySum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private MySum mySum;

  public static void main(String[] args){
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... args) throws Exception {
//      String res = ;

        mySum.sum("1", "eeee");
        mySum.sum("1", "3");
        mySum.sum("100", "1e8");
        mySum.sum("-7.1", "100");
        mySum.sum("-.5", ".6");
  }
}
