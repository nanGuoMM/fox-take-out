package top.nanguomm.fox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  // DocumentationType.SWAGGER_2 固定的，代表swagger2
//                .groupName("分布式任务系统") // 如果配置多个文档的时候，那么需要配置groupName来分组标识
                .apiInfo(apiInfo()) // 用于生成API信息
                .select() // select()函数返回一个ApiSelectorBuilder实例,用来控制接口被swagger做成文档
                .apis(RequestHandlerSelectors.basePackage("top.nanguomm.fox.controller")) // 用于指定扫描哪个包下的接口
                .paths(PathSelectors.any())// 选择所有的API,如果你想只为部分API生成文档，可以配置这里
                .build();
    }

    /**
     * 用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
     * @return ApiInfoBuilder
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("小狐狸外卖") //  可以用来自定义API的主标题
                .description("管理端和用户端所有接口") // 可以用来描述整体的API
                .termsOfServiceUrl("https://nanguomm.top") // 用于定义服务的域名
                .contact(new Contact("nanGuoMM","https://nanguomm.top","zhuyuqinss@gmail.com"))
                .version("v1.1") // 可以用来定义版本。
                .build(); //
    }
}
