package bingege.blog.article

import bingege.blog.article.payload.CreateArticleCategory
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ArticleController::class)
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

        mvc.perform(post("/api/article/category", CreateArticleCategory("test")))
            .andExpect(status().isOk)
    }
}
