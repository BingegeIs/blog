package bingege.blog.security.token

import org.slf4j.LoggerFactory
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

//@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint {

    @Throws(IOException::class, ServletException::class)
    override fun commence(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse,
        e: AuthenticationException
    ) {
        logger.info(buildMessage(httpServletRequest))
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
            "Sorry, You're not authorized to access this resource.")
    }

    private fun buildMessage(request: HttpServletRequest): String {
        val msg = StringBuilder()
        val user = String.format("%-23s", "Unauthorized anonymous")
        msg.append(user)
            .append(" At ")
            .append(String.format("%16s", request.remoteHost))
            .append(" -> ")
            .append("[")
            .append(request.method)
            .append("]")
            .append(request.requestURI)
        val queryString = request.queryString
        if (queryString != null) {
            msg.append('?').append(queryString)
        }
        return msg.toString()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint::class.java)
    }
}
