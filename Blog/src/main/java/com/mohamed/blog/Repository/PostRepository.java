package com.mohamed.blog.Repository;

import com.mohamed.blog.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
