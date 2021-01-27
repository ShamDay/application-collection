package com.zk.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class cloudsave8001Main {
    public static void main(String[] args) {
        SpringApplication.run(cloudsave8001Main.class,args);
    }
}
