package com.kurly.delivery.domain.user.dto.response;

import com.kurly.delivery.domain.user.model.JobType;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class GetJobTypeResponseDto {
    private Long jobTypeId;
    private String jobType;
    private LocalTime jobStartTime;
    private LocalTime jobFinishTime;
    private String description;

    public GetJobTypeResponseDto(JobType jobType) {
        this.jobTypeId = jobType.getId();
        this.jobType = jobType.getType().name();
        this.jobStartTime = jobType.getStartTime();
        this.jobFinishTime = jobType.getFinishTime();
        this.description = jobType.getDescription();
    }
}
