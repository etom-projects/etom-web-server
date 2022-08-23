package com.kurly.delivery.domain.user.repository;

import com.kurly.delivery.domain.user.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType, Long> {
}
