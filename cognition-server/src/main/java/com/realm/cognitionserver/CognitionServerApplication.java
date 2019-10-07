package com.realm.cognitionserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka服务启动
 * @author 1122
 */
@EnableEurekaServer
@SpringBootApplication
public class CognitionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CognitionServerApplication.class, args);
    }

}
