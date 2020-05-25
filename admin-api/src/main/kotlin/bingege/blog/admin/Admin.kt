package bingege.blog.admin

import bingege.blog.common.base.Base
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
    var password: String

) : Base() {

    // 昵称
    var nickname: String? = null

    // 上个登录时间
    var loginAt: ZonedDateTime? = null

    // 简介
    var description: String? = null

    // 头像
    var avatar: String? = null
}
