package application.job.api.rest;

import application.job.api.rest.data.Post;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaTestApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void contextLoads() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("restTemplate"));
    }

    @Test
    public void testHomePage() throws Exception {
        this.mockMvc.perform(get("")).andDo(print())
                .andExpect(view().name("index"));
    }

    @Test
    public void getDetailsDataTest() throws Exception {
        this.mockMvc.perform(get("/postDetails/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("postDetails"));

        Post post = new Post("1", "1", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "quia et suscipit\n" +
                        "suscipit recusandae consequuntur expedita et cum\n" +
                        "reprehenderit molestiae ut ut quas totam\n" +
                        "nostrum rerum est autem sunt rem eveniet architecto");

        Post post1 = (Post) this.mockMvc.perform(get("/postDetails/1")).andReturn().getModelAndView().getModel().get("post");

        Assert.assertEquals(post1.getId(), post.getId());
        Assert.assertEquals(post1.getUserId(), post.getUserId());
        Assert.assertEquals(post1.getTitle(), post.getTitle());
        Assert.assertEquals(post1.getBody(), post.getBody());
    }

    @Test
    public void createPostTest() throws Exception {
        this.mockMvc.perform(get("/createPost"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("createPost"));
    }

    @Test
    public void createNewPostTest() throws Exception {
        String s = this.mockMvc.perform(post("/createNewPost")
                .param("userID", "1")
                .param("title", "dummy title")
                .param("body", "nice body")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        String successMessage = "A new post was created with the id: 101.";
        Assert.assertEquals(successMessage, s);
    }

    @Test
    public void deletePostTest() throws Exception {
        String s = this.mockMvc.perform(delete("/deletePost/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andReturn().getResponse().getContentAsString();

        String successMessage = "The post with id: 1 was successful deleted.";
        Assert.assertEquals(successMessage, s);
    }
}
