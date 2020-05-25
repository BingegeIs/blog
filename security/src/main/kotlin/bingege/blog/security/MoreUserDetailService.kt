package bingege.blog.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

interface MoreUserDetailService : UserDetailsService {

    fun find(id: Long): UserDetails
}