package application.job.api.rest.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Post object class
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

    private String userId;

    private String id;

    private String title;

    private String body;

    public Post() {

    }
    public Post(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Post(String id, String userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
