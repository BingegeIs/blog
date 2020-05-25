package bingege.blog.admin

import bingege.blog.admin.Admin


interface AdminService {

    /**
     * 是否存在
     */
    fun exist(): Boolean

    /**
     * 注册
     */
    fun register(account: String, password: String): Admin

    /**
     * 登录
     */
    fun login(account: String, password: String): Admin

    fun find(id: Long): Admin

    fun findByAccount(account: String): Admin
}