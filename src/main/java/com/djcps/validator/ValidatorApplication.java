package com.djcps.validator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yhc
 * @date 2020/5/7 20:20
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.djcps.validator.**.dao"})
public class ValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorApplication.class, args);
    }

}
