package bingege.blog.admin

import bingege.blog.admin.payload.LoginRequest
import bingege.blog.config.GlobalProperties
import bingege.blog.security.JwtProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.ZonedDateTime

@RequestMapping("/api/auth")
@RestController
class AuthController(
    @Autowired val adminService: AdminService,
    @Autowired val authenticationManager: AuthenticationManager,
    @Autowired val globalProperties: GlobalProperties
) {
    @GetMapping("/exist")
    fun exist(): Boolean {
        return adminService.exist()
    }

    @PostMapping("/login")
    fun login(@RequestBody param: LoginRequest): JwtAuthenticationResponse {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(param.username, param.password)
        )

        val tokenExpireAt = ZonedDateTime.now().plusSeconds(globalProperties.duration.toSeconds())
        val token = JwtProvider(globalProperties.secret)
            .build(authentication.principal as Admin, tokenExpireAt)

        return JwtAuthenticationResponse(
            accessToken = token,
            expireAt = tokenExpireAt
        )
    }

    @PostMapping("/register")
    fun register(@RequestBody param: LoginRequest): JwtAuthenticationResponse {
        val admin = adminService.register(param.username, param.password)
        val tokenExpireAt = ZonedDateTime.now().plusSeconds(globalProperties.duration.toSeconds())
        val token = JwtProvider(globalProperties.secret)
            .build(admin, tokenExpireAt)

        return JwtAuthenticationResponse(
            accessToken = token,
            expireAt = tokenExpireAt
        )
    }
}

data class JwtAuthenticationResponse(
    var accessToken: String? = null,
    var tokenType: String = "Bearer",
    var expireAt: ZonedDateTime? = null
)
