package com.zy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 17616
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zy.sys.mapper")
public class StockErpApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockErpApplication.class, args);
    }

}
