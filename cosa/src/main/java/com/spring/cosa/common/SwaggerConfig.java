package com.spring.cosa.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Value("${api_name}")
	private String api_name;

	@Value("${api_version}")
	private String api_version;

	@Value("${api_description}")
	private String api_description;
	
	@Value("${basePackage}")
	private String basePackage;
	
	@Value("${authorization}")
	private String authorization;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

		super.addResourceHandlers(registry);
	}

	@Bean
	public Docket api() {
		// API를 테스트할 때 모든 API에 전역 파라미터를 설정
		Parameter parameterBuilder = new ParameterBuilder().name(HttpHeaders.AUTHORIZATION).description(authorization)
				.modelRef(new ModelRef("string")).parameterType("header").required(false).build();

		List<Parameter> globalParamters = new ArrayList<>();
		globalParamters.add(parameterBuilder);

		return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(globalParamters).apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any())
				.build();
	}

	public ApiInfo apiInfo() { // 해당 api의 정보
		return new ApiInfoBuilder().title(api_name).version(api_version).description(api_description).build();
	}

}
