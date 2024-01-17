package com.mohamed.blog.Controller;

import com.mohamed.blog.Model.Post;
import com.mohamed.blog.Model.User;
import com.mohamed.blog.Service.PostService;
import com.mohamed.blog.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {


    private final PostService postService;

    private final UserService userService;

    // create new Post
    @PostMapping("/user/{userId}")
    public Post createPost(@RequestBody Post post, @PathVariable Long userId) throws Exception {
        User user = userService.findUserById(userId);
        Post createPost = postService.createPost(post, user);
        return createPost;
    }

    // find all Posts
    @GetMapping()
    public List<Post> getAllPosts() throws Exception {
        List<Post> posts = postService.findAllPosts();
        return posts;
    }

    // delete Post
    @DeleteMapping("/{postId}")
    public String deletePost (@PathVariable Long postId) throws Exception {
        postService.deletePost(postId);
        return "Post deleted Successfully.";
    }

    // update Post
    @PutMapping("/{id}")
    public Post updatePost(@RequestBody Post post, @PathVariable Long id) throws Exception {
        Post updatedPost = postService.updatePost(post,id);
        return updatedPost;
    }

    // like Post
    @PutMapping("/{id}/like/user/{userId}")
    public Post likePost(@PathVariable Long userId, @PathVariable Long id) throws Exception {

        User user = userService.findUserById(userId);

        Post likedPost = postService.likePost(id,user);
        return  likedPost;
    }
}
