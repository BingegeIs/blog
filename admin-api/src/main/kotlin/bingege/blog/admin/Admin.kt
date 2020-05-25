package bingege.blog.admin

import bingege.blog.common.base.Base
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "admin")
class Admin(

    // 账号
    @Column(unique = true)
    var account: String,

    // 密码
    private var password: String

) : Base(), UserDetails {

    // 昵称
    var nickname: String? = null

    // 上个登录时间
    var loginAt: ZonedDateTime? = null

    // 简介
    var description: String? = null

    // 头像
    var avatar: String? = null

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }

    override fun isEnabled(): Boolean = true

    override fun getUsername(): String = account

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true
}
