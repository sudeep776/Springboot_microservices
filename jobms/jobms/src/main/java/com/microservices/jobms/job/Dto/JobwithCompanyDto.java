package com.microservices.jobms.job.Dto;

import com.microservices.jobms.job.Job;
import com.microservices.jobms.job.external.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobwithCompanyDto {
    private Job job;
    private Company company; 
}
