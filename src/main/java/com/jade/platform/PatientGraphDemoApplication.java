package com.jade.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//@ComponentScan(basePackages = {"com.jade.platform.domain", "com.jade.platform.service", "com.jade.platform.repository", "com.jade.platform.web"})
@SpringBootApplication
public class PatientGraphDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientGraphDemoApplication.class, args);
    }

}
