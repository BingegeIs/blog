package bingege.blog.config

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

@Configuration
class WebConfig: WebMvcAutoConfiguration() {

//    @Bean
//    fun templateResolver(): ClassLoaderTemplateResolver {
//        val resolver = ClassLoaderTemplateResolver()
//        resolver.apply {
//            prefix = "templates/"
//            suffix = ".html"
//            setTemplateMode("HTML5")
//            isCacheable = false
//            characterEncoding = "UTF-8"
//        }
//        return resolver
//    }
//
//    @Bean
//    fun templateEngine(): SpringTemplateEngine {
//        val engine = SpringTemplateEngine()
//        engine.setTemplateResolver(templateResolver())
//        return engine
//    }
//
//    @Bean
//    fun viewResolver() {
//        val viewResolver = ThymeleafViewResolver()
//        viewResolver.templateEngine = templateEngine()
//    }

}