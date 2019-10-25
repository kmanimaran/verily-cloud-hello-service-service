package com.verily.example.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingApplication implements CommandLineRunner {
  private static Logger log = LoggerFactory.getLogger(GreetingApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(GreetingApplication.class, args);
  }

  @Override
  public void run(String... args) {
    log.info("StartApplication...");
  }
}
