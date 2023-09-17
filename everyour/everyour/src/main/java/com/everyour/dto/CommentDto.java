package com.everyour.dto;

import lombok.Data;

@Data
public class CommentDto {
    public class CommentDTO {
        private Long commentId;
        private String content;
        private Long postId;
        private String username;

    }
}
