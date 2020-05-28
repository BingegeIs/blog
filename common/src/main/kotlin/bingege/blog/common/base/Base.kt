package bingege.blog.common.base

import com.vladmihalcea.hibernate.type.array.IntArrayType
import com.vladmihalcea.hibernate.type.array.StringArrayType
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType
import com.vladmihalcea.hibernate.type.json.JsonNodeStringType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.ZonedDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@TypeDefs(
    TypeDef(name = "string-array", typeClass = StringArrayType::class),
    TypeDef(name = "int-array", typeClass = IntArrayType::class),
    TypeDef(name = "json", typeClass = JsonStringType::class),
    TypeDef(name = "jsonb", typeClass = JsonBinaryType::class),
    TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType::class),
    TypeDef(name = "json-node", typeClass = JsonNodeStringType::class)
)
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class Base : Serializable {

    @Id
    open var id: Long = 0L

    @CreatedDate
    @Column(columnDefinition = "timestamptz")
    open var createAt: ZonedDateTime = ZonedDateTime.now()

    @LastModifiedDate
    @Column(columnDefinition = "timestamptz")
    open var updateAt: ZonedDateTime = ZonedDateTime.now()

    open var delete: Boolean = false

    @Column(columnDefinition = "timestamptz")
    open var deleteAt: ZonedDateTime? = null

    open fun delete() {
        this.delete = true
        this.deleteAt = ZonedDateTime.now()
    }
}