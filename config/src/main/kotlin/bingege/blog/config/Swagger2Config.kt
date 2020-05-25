package bingege.blog.config

import bingege.blog.common.base.CurrentUser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.annotation.AuthenticationPrincipal
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.ParameterBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Parameter
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger2Config {

    @Bean
    fun createRestApi(): Docket {
        val tokenPar = ParameterBuilder()
        val pars = ArrayList<Parameter>()
        tokenPar.name("Authorization")
            .description("令牌")
            .modelRef(ModelRef("string"))
            .parameterType("header")
            .required(false).build()
        pars.add(tokenPar.build())
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .ignoredParameterTypes(AuthenticationPrincipal::class.java)
            .ignoredParameterTypes(CurrentUser::class.java)
            .select()
            .apis(RequestHandlerSelectors.basePackage("bingege"))
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(pars)
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("Blog Api")
            .description("Just for bingege!")
            .version("v0")
            .build()
    }
}
