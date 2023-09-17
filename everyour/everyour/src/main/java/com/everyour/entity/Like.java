package com.everyour.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId; // 좋아요 식별 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post; // 게시물



    public Like(Post post) {
        this.post = post;

    }

    public void setPost(Post post) {
        this.post = post;
    }


}
