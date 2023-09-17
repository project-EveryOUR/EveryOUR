package com.jolp.everyour.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId; // 카테고리 식별 아이디

    private String name; // 카테고리 이름

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>(); // 해당 카테고리에 속한 게시물 리스트

    public Category(String name) {
        this.name = name;
    }

    public void addPost(Post post) {
        posts.add(post);
        post.setCategory(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.setCategory(null);
    }


}
