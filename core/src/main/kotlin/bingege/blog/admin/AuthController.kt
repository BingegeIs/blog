package bingege.blog.admin

import bingege.blog.admin.payload.LoginRequest
import bingege.blog.config.GlobalProperties
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/auth")
@RestController
@Api(tags = ["R 认证"])
class AuthController(
    @Autowired val adminService: AdminService,
    @Autowired val authenticationManager: AuthenticationManager,
    @Autowired val globalProperties: GlobalProperties
) {
    @GetMapping("/exist")
    fun exist(): Boolean {
        return adminService.exist()
    }

    @PostMapping("/register")
    fun register(@RequestBody param: LoginRequest) {
        val admin = adminService.register(param.username!!, param.password!!)
    }
}

