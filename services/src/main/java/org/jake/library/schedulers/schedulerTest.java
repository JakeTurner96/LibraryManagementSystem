package org.jake.library.schedulers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class schedulerTest {

    private static final Logger log = LoggerFactory.getLogger(schedulerTest.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 10000)
    public void currentTime(){
        log.info("Current time is {}", dateFormat.format(new Date()));

    }
}
