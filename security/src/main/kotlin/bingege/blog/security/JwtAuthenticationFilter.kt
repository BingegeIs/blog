package bingege.blog.security

import bingege.blog.admin.Admin
import bingege.blog.admin.AdminService
import bingege.blog.config.GlobalProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 认证过滤器
 *
 * @author yu
 */
class JwtAuthenticationFilter : OncePerRequestFilter() {
    @Autowired
    lateinit var global: GlobalProperties

    @Autowired
    lateinit var adminService: AdminService

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        getJwtFromRequest(request)?.also { token ->
            val user = adminService.find(
                JwtProvider(global.secret).parse(token)
            )
            SecurityContextHolder.getContext().authentication = authentication(request, user)
        }

        filterChain.doFilter(request, response)
    }

    private fun authentication(request: HttpServletRequest, user: Admin): UsernamePasswordAuthenticationToken {
        val authentication = UsernamePasswordAuthenticationToken(user, null, user.authorities)
        authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
        return authentication
    }

    private fun getJwtFromRequest(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(HEADER)
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(PREFIX)) {
            return bearerToken.substring("Bearer ".length)
        }
        return null
    }

    companion object {
        private const val PREFIX = "Bearer "
        private const val HEADER = "Authorization"

        private val logger = LoggerFactory.getLogger(JwtAuthenticationFilter::class.java)
    }
}
