package com.everyour.repository;

import com.everyour.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    void deleteByUserUsernameAndPostId(String username, Long postId); //username, postId에 해당하는 좋아요 정보 삭제

    Boolean existsByUserUsernameAndPostId(String username, Long postId); //username, postId에 해당하는 좋아요 정보 존재 여부 반환

    List<Like> findAllByUserUsername(String username); //username으로 사용자가 좋아요 누른 정보들 리스트로 반환
}