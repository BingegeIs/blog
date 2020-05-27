package bingege.blog.common.base

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.Optional

@NoRepositoryBean
interface BaseRepository<T : Base> : JpaRepository<T, Long> {

    fun findByIdAndDeleteIsFalse(id: Long): Optional<T>

}