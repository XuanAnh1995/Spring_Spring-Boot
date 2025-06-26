package com.luuviet.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
// mang nhiều ý nghĩa
// gộp bên trong gôm @Configuration
//					@ComponentScan(...)
//					...
// class AppConfig bên phiên bản pure Spring vừa làm
public class SpringbootToGoApplication {

	// tạo @BEAN chỗ này đúng ko thầy ? Đúng em !!!
	@Bean("ngocTrinh")
	public ExcelGenerator excelGenerator() {
		return new ExcelGenerator();
	}

	public static void main(String[] args) {
		// Tạo ra Context, IoC Container chứa các BEAN
		// Câu lệnh này xong là các bean đã xong
		ApplicationContext context = SpringApplication.run(SpringbootToGoApplication.class, args);

		// được quyền xài bean sau lệnh này, quay trở lại bài Spring vừa rồi
		ExcelGenerator excelGenerator = (ExcelGenerator) context.getBean("ngocTrinh");

		excelGenerator.generateFile(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	}

}
