package bingege.blog.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class SecurityConfig {

    @Bean
    fun passwordEncode(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
