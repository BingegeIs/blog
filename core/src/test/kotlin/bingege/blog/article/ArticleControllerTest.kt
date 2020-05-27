package bingege.blog.article

import bingege.blog.SecurityTestConfig
import bingege.blog.article.payload.CreateArticleCategory
import com.google.gson.Gson
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ArticleController::class)
@Import(SecurityTestConfig::class)
@WithMockUser
class ArticleControllerTest {

    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var articleService: ArticleService

    @Test
    fun createCategory() {
        given(articleService.createCategory("test"))
            .willReturn(ArticleCategory("test"))

        val category = CreateArticleCategory("test")
        mvc.perform(post("/api/article/category")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(Gson().toJson(category)))
            .andExpect(status().isOk)
    }
}
