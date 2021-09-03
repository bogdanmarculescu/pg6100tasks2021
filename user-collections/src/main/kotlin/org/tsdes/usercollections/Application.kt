package org.tsdes.usercollections

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@Configuration
@EnableSwagger2
class Application {

    @Bean
    fun swaggerApi() : Docket {
        return Docket(DocumentationType.OAS_30)
            .select()
            .paths(PathSelectors.any())
            .build()
    }


}



fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}