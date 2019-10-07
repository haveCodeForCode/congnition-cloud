package com.realm.cognitionadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


//@EnableFeignClients(basePackages = {"com.bootdo"})
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class CognitionAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CognitionAdminApplication.class, args);
    }

}
