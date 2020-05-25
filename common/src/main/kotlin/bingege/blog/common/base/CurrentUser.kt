package bingege.blog.common.base

import org.springframework.security.core.annotation.AuthenticationPrincipal

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention
@kotlin.annotation.MustBeDocumented
@AuthenticationPrincipal
annotation class CurrentUser