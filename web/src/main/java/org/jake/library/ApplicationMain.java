package org.jake.library;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Log4j2
@EnableScheduling
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void onApplicationStart() {
        log.info("Library application started...");
    }
}
