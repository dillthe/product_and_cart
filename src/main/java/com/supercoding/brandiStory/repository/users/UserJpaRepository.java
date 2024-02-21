package com.supercoding.brandiStory.repository.users;

import com.supercoding.brandiStory.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);

    // 마이페이지에서 내 정보 조회
    Optional<UserEntity> findById(Integer id);
    
}
