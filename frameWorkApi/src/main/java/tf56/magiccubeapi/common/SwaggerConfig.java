package tf56.magiccubeapi.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置类
 * 
 * @author Jinpeng.Yang
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan("tf56.magiccubeapi.controller")
public class SwaggerConfig {

    @Bean
    public Docket createAPI() {
        return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder().title("运力魔方系统magiccubeApi接口文档").version("0.0.1").build();

        return apiInfo;
    }
}
