package com.ycz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan("com.ycz.dao")
public class PersonManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonManageApplication.class, args);
	}
}
