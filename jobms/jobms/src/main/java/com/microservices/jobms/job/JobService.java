package com.microservices.jobms.job;

import com.microservices.jobms.job.Dto.JobwithCompanyDto;

import java.util.List;


public interface JobService {
    List<JobwithCompanyDto> findAll();
    void createJob(Job job);

    Job getJobByID(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobByID(Long id, Job updatedJob);
}
