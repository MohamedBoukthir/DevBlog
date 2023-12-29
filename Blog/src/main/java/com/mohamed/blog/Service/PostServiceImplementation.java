package com.mohamed.blog.Service;

import com.mohamed.blog.Model.Post;
import com.mohamed.blog.Model.User;
import com.mohamed.blog.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService{

    @Autowired
    private PostRepository postRepo;

    // create post
    @Override
    public Post createPost(Post post, User user) {
        Post newPost = new Post();

        newPost.setTitle(post.getTitle());
        newPost.setImage(post.getImage());
        newPost.setDescription(post.getDescription());
        newPost.setUser(user);
        newPost.setCreatedAt(LocalDate.now());

        return postRepo.save(newPost);
    }

    // find Post By ID
    @Override
    public Post findPostById(Long id) throws Exception {
        Optional<Post> optional = postRepo.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }
        throw  new Exception("Post With ID : " + id + " Not Exist");
    }

    // delete Post
    @Override
    public void deletePost(Long id) throws Exception {
        // firstly we will check if the post exist
        findPostById(id);
        // then we will delete it
        postRepo.deleteById(id);
    }

    // update post
    @Override
    public Post updatePost(Post post, Long id) throws Exception {
        // firstly we will check if the post exist
        Post oldPost = findPostById(id);

        // then edit fields
        if (post.getTitle() != null){
            oldPost.setTitle(post.getTitle());
        }
        if (post.getImage() != null){
            oldPost.setImage(post.getImage());
        }
        if (post.getDescription() != null){
            oldPost.setDescription(post.getDescription());
        }

        return postRepo.save(oldPost);
    }

    // Show All Posts
    @Override
    public List<Post> findAllPosts() {
        return postRepo.findAll();
    }

    // Like Post
    @Override
    public Post likePost(Long postId, User user) throws Exception {
        // firstly we will check if the post exist
        Post post = findPostById(postId);

        if (post.getLikes().contains(user.getId())){
            post.getLikes().remove(user.getId());
        }else {
            post.getLikes().add(user.getId());
        }
        return postRepo.save(post);
    }
}
