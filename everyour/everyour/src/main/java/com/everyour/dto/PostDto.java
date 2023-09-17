package com.everyour.dto;

import lombok.*;

@Data
@Builder
public class PostDto {
    private Long postId;
    private String title;
    private String content;
    private Long categoryId;
    private Long userId;
    private int viewCnt;
    private int likeCnt;
    private int commentCnt;

}
