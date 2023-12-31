package com.youkenhei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringbootTliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTliasApplication.class, args);
    }


}
