package com.cognition.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *
 * @author taoya
 */
@SpringBootApplication
@EnableFeignClients
@EnableE
public class SystemApiApplication {

    public static void main( String[] args ) {
        SpringApplication.run(SystemApiApplication.class,args);
    }
}
