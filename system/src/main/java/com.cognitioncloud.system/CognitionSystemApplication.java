package com.cognitioncloud.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 权限项目启动器
 *
 * @author 1122
 */
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableFeignClients(basePackages = "com.realm.cognitionsystem")
@MapperScan("com.realm.cognitionsystem.dao")
@EnableDiscoveryClient
public class CognitionSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CognitionSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Cognition-System 启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
