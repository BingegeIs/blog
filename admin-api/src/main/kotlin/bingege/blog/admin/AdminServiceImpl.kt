package bingege.blog.admin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AdminServiceImpl(
    @Autowired val adminRepository: AdminRepository,
    @Autowired val passwordEncoder: PasswordEncoder
) : AdminService, AdminRepository by adminRepository {


    override fun exist(): Boolean {
        val count = count()
        return count >= 1
    }

    override fun register(account: String, password: String): Admin {
        if (exist()) throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Already Exist")
        val encodePwd = passwordEncoder.encode(password)
        return Admin(account, encodePwd)
            .let(this::save)
    }

    override fun login(account: String, password: String): Admin {
        TODO()
    }
}
