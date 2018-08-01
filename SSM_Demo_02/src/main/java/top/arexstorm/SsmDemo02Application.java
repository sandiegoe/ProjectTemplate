package top.arexstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.arexstorm.resolver.BlankHeaderArgumentResolver;
import top.arexstorm.resolver.BlankParamArgumentResolver;

import java.util.List;

@SpringBootApplication
public class SsmDemo02Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SsmDemo02Application.class, args);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new BlankParamArgumentResolver()); // 输入参数非空验证
		resolvers.add(new BlankHeaderArgumentResolver()); // 请求头中输入参数非空验证
	}
}
