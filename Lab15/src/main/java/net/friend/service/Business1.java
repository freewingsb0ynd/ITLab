package net.friend.service;

import lombok.extern.slf4j.Slf4j;
import net.friend.TrackTime;
import net.friend.repository.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Business1 {

  @Autowired
  private Dao1 dao1;

  @TrackTime
  public String calculateSomething(){
    String value = dao1.retrieveSomething();
    log.info("In Business - {}", value);
    return value;
  }
}
