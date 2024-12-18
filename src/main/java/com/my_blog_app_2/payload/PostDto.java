package com.my_blog_app_2.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
public class PostDto
{
    @NotEmpty
    @Size(min=3,message="title should be atleast 3 characters")
    private String title;
    @NotEmpty
    @Size(min=5,message="content should be atleast 5 characters")
    private String content;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
