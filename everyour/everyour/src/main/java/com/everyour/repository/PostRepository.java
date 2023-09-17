package com.everyour.repository;

import com.everyour.entity.Category;
import com.everyour.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategory(Category category); //카테고리로 게시물 조회

    List<Post> findByUserUsername(String username); //username으로 게시물 조회

    List<Post> findByTitleContaining(String title); // title로 게시물 조회
}