package com.kurly.delivery.domain.user.repository;

import com.kurly.delivery.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user " +
            "from User user " +
            "where user.email=:email and user.status='ACTIVE' ")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("select count(user) > 0 " +
            "from User user " +
            "where user.email = :email ")
    Boolean existsByEmail(String email);
}
