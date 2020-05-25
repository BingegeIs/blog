package bingege.blog.security

import bingege.blog.admin.Admin
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.time.ZonedDateTime
import java.util.Date

class JwtProvider(val secret: String) {

    fun build(user: Admin, expireAt: ZonedDateTime): String {
        return Jwts.builder()
            .setSubject(user.id.toString())
            .setExpiration(Date.from(expireAt.toInstant()))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()
    }

    fun build(user: Admin, expireSeconds: Long): String {
        return build(user, ZonedDateTime.now().plusSeconds(expireSeconds))
    }

    fun parse(token: String): Long {
        val claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
        return claims.subject.toLong()
    }
}

