package bingege.blog.admin

import bingege.blog.admin.Admin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface AdminRepository : JpaRepository<Admin, Long>, QuerydslPredicateExecutor<Admin> {
}