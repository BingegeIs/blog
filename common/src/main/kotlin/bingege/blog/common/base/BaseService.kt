package bingege.blog.common.base

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@NoRepositoryBean
interface BaseService<T : Base> : BaseRepository<T> {

    fun findOrThrow(id: Long): T {
        return findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

    fun findExistOrThrow(id: Long): T {
        return findByIdAndDeleteIsFalse(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

    fun softDelete(id: Long) {
        val t = findExistOrThrow(id)
        t.delete()
        save(t)
    }
}