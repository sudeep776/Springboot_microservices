package com.microservices.SpringbootMcs.job;

import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobByID(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobByID(Long id, Job updatedJob);
}
