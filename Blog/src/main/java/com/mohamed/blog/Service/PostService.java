package com.mohamed.blog.Service;

import com.mohamed.blog.Model.Post;
import com.mohamed.blog.Model.User;

import java.util.List;

public interface PostService {

    public Post createPost(Post post, User user);

    public Post findPostById(Long id) throws Exception;

    public void deletePost(Long id) throws Exception;

    public Post updatePost(Post post, Long id) throws Exception;

    public List<Post> findAllPosts();

    public Post likePost(Long postId, User user) throws Exception ;

}
