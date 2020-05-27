package bingege.blog.common.base

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@NoRepositoryBean
interface BaseRepository<T : Base> : JpaRepository<T, Long> {

    fun findOrThrow(id: Long): T {
        return findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }
}