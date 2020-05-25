package bingege.blog.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
@ConfigurationProperties(prefix = "global")
class GlobalProperties {

    lateinit var secret: String
    lateinit var duration: Duration
}
