package bingege.blog.admin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AdminServiceImpl(
    @Autowired val adminRepository: AdminRepository
) : AdminService, AdminRepository by adminRepository {

    val q: QAdmin = QAdmin.admin

    override fun exist(): Boolean {
        val count = count()
        return count >= 1
    }

    override fun register(account: String, password: String): Admin {
        if (exist()) throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Already Exist")
        val encodePwd = BCryptPasswordEncoder().encode(password)
        return Admin(account, encodePwd)
            .let(this::save)
    }

    override fun login(account: String, password: String): Admin {
        TODO()
    }

    override fun find(id: Long): Admin {
        return findById(id).orElseThrow()
    }

    override fun findByAccount(account: String): Admin {
        val expression = q.account.eq(account)
        return findOne(expression).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

}
