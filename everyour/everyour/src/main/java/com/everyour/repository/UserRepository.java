package com.everyour.repository;

import com.everyour.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginId(Long loginId);

    User findByUsername(String username);
    Boolean existsByLoginId(Long loginId);
    Boolean existsByUsername(String username);

}
