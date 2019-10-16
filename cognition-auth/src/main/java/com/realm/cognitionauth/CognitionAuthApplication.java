package com.realm.cognitionauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 权限项目启动器
 *
 * @author 1122
 */
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.realm.*.dao")
@EnableDiscoveryClient
public class CognitionAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CognitionAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
