package com.pluralsight.blog;

import java.util.List;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    private PostRepository postRepository = null;

    public BlogController(PostRepository _postRepository) {
        super();
        postRepository = _postRepository;
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap) {
        Post post = postRepository.findById(id);
        modelMap.put("post", post);
        return "post-details";
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {
        List<Post> allPosts = postRepository.getAllPosts(); 
        modelMap.put("posts", allPosts);
        return "home";
    }
}
