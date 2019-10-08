package application.job.api.rest.controller;

import application.job.api.rest.data.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller
 */
@Controller
public class PostController {

    private static final String POSTS = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Returns the createPost view
     * @return
     */
    @GetMapping("createPost")
    public String createPost() {
        return "createPost";
    }

    /**
     * Creates a new post
     * @param userID
     * @param title
     * @param body
     * @return
     */
    @PostMapping("createNewPost")
    @ResponseBody
    public String createNewPost(@RequestParam("userID") String userID, @RequestParam("title") String title, @RequestParam("body") String body) {
        Post post = new Post(userID, title, body);
        HttpEntity<Post> request = new HttpEntity<>(post);
        String message = "";
        ResponseEntity<Post> response;
        try{
            response = restTemplate.exchange(POSTS, HttpMethod.POST, request, Post.class);
            message = "A new post was created with the id: " + response.getBody().getId() + ".";
        }catch(Exception e){
            message = "An error has ocurred while creating a new post.";
        }
        return message;
    }

    /**
     * Deletes a post by its id
     * @param postId
     * @return
     */
    @DeleteMapping("deletePost/{postId}")
    @ResponseBody
    public String deletePost(@PathVariable("postId")  String postId) {
        String entityUrl = POSTS + "/" + postId;
        String message = "";
        try{
            ResponseEntity<Void> responseEntity =  restTemplate.exchange(entityUrl,
                    HttpMethod.DELETE,
                    null,
                    Void.class,
                    postId);
            message =  "The post with id: " + postId + (responseEntity.getStatusCode().is2xxSuccessful() ?  " was successful deleted." :" was not successful deleted." );
        }catch(Exception e){
            message = "The post with id: " + postId + " was not successful deleted.";
        }
        return message;
    }

    /**
     * Returns a post details
     * @param postId
     * @param modelMap
     * @return
     */
    @GetMapping(value = "postDetails/{postId}")
    public ModelAndView getPostDetail(@PathVariable("postId")  String postId,  ModelMap modelMap){
        Post post = restTemplate.getForObject(POSTS + "/" + postId, Post.class);
        modelMap.put("post", post);
        return new ModelAndView("postDetails");
    }

    /**
     * Error page for handling object conversion errors
     * @return
     */
    @ExceptionHandler(RestClientException.class)
    public String handleException() {
        return "error-page";
    }

    /**
     * Home page with a list of some posts
     * @param modelMap
     * @return
     */
    @GetMapping({"/"})
    public String home(ModelMap modelMap) {
        ResponseEntity<List<Post>> postList = restTemplate.exchange(
                POSTS,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>(){});
        modelMap.put("postList", postList.getBody());
        return "index";
    }
}
