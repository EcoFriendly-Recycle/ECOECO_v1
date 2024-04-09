package com.recycle.ecoeco.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.recycle.ecoeco")
@MapperScan(basePackages ="com.recycle.ecoeco", annotationClass = Mapper.class)
public class EcoecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoecoApplication.class, args);
	}

}
