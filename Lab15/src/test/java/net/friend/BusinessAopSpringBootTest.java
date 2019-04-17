package net.friend;

import lombok.extern.slf4j.Slf4j;
import net.friend.service.Business1;
import net.friend.service.Business2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BusinessAopSpringBootTest {

  @Autowired
  private Business1 business1;

  @Autowired
  private Business2 business2;

  @Test
  public void invokeAOPStuff() {
    log.info(business1.calculateSomething());
    log.info(business2.calculateSomething());
  }
}

