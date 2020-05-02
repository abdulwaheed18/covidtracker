package com.waheedtechblog.covid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @Author AbdulWaheed18@gmail.com
 */
@Configuration
public class SwaggerConfig {
    // In case of any confusion, Always check for JAVA docs
    public static final Contact DEFAULT_CONTACT = new Contact("Abdul Waheed", "www.waheedtechblog.com",
            "abdulwaheed18@gmail.com");

    @SuppressWarnings("rawtypes")
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Covid 19 Tracker",
            "Covid 19 tracker", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).select()
                .apis(RequestHandlerSelectors.basePackage("com.waheedtechblog.covid")).build();
    }
}
