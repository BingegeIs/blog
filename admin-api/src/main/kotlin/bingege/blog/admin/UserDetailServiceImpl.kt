package bingege.blog.admin

import bingege.blog.security.MoreUserDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl(
    @Autowired val adminService: AdminService
) : MoreUserDetailService {
    override fun find(id: Long): UserDetails {
        return adminService.find(id)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        return adminService.findByAccount(username)
    }
}