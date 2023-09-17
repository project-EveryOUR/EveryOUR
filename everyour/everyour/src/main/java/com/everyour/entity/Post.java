package com.everyour.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId; // 게시물 식별 아이디

    private String title; // 제목

    private String content; // 내용

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category; // 카테고리

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 작성자

    private int viewCnt; //조회수

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>(); // 좋아요 리스트
    private int likeCnt; //좋아요 수

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments= new ArrayList<>(); // 댓글 리스트
    private int commentCnt; //댓글 수

    public Post(String title, String content, Category category, User user) {
        this.title= title;
        this.content= content;
        this.category= category;
        this.user= user;
    }


    public void addLike(Like like) {
        likes.add(like);
        like.setPost(this);
        likeCnt++;  // 좋아요 수 증가
    }


    public void removeLike(Like like) {
        likes.remove(like);
        like.setPost(null);
        likeCnt--;  // 좋아요 수 감소
    }


    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
        commentCnt++; // 댓글 수 증가
    }



    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(null);
        commentCnt--; //댓글 수 감소
    }

    //댓글 수정
    public void updateComment(Long commentId, String updatedContent) {
        for (Comment comment : comments) {
            if (comment.getCommentId().equals(commentId)) {  // 댓글 식별 아이디로 해당 댓글 찾기
                comment.setContent(updatedContent);  // 댓글 내용 업데이트
                break;
            }
        }
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
