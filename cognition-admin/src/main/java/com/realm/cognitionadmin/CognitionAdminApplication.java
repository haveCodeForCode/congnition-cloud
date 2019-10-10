package com.realm.cognitionadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author 1122
 */
@EnableEurekaClient
@SpringBootApplication
public class CognitionAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CognitionAdminApplication.class, args);
    }

}
