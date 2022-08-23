package com.kurly.delivery.domain.user.repository;

import com.kurly.delivery.domain.user.model.UserCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserCarRepository extends JpaRepository<UserCar, Long> {

    @Query(value = "select userCar " +
            "from UserCar userCar " +
            "where userCar.user.id = :userId")
    List<UserCar> findAllByUserId(@Param("userId") Long userId);
}
