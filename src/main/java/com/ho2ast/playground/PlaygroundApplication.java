package com.ho2ast.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PlaygroundApplication {

  public static void main(String[] args) {
    SpringApplication.run(PlaygroundApplication.class, args);
  }

}
