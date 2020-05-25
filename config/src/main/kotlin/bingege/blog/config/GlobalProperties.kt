package bingege.blog.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "global")
class GlobalProperties {

    lateinit var secret: String
}