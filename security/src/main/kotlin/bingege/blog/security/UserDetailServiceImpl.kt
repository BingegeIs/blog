package bingege.blog.security

import bingege.blog.admin.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl(
    @Autowired val adminService: AdminService
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return adminService.findByAccount(username)
    }
}