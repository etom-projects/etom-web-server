package com.kurly.delivery.domain.user.service;

import com.kurly.delivery.domain.user.model.JobType;
import com.kurly.delivery.domain.user.repository.JobTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobTypeRepository jobTypeRepository;

    @Transactional(readOnly = true)
    public List<JobType> getJobTypes() {
        return jobTypeRepository.findAll();
    }
}
