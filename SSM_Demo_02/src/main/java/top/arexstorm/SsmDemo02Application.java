package top.arexstorm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan(basePackages = "top.arexstorm.dao")
@SpringBootApplication
public class SsmDemo02Application {

	public static void main(String[] args) {
		SpringApplication.run(SsmDemo02Application.class, args);
	}
}
