package com.microservices.jobms.job;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//get -- all jobs
//get -- jobs by id
//post - add new job/jobs
//delete - jobs by id
//put - update jobs by id

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService){
        this.jobService=jobService;
    }
    @GetMapping()
    public ResponseEntity<List<Job>> findAll(){
        List<Job> jobList = jobService.findAll();
        return new ResponseEntity<>(jobList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findByID(@PathVariable Long id){
        Job job= jobService.getJobByID(id);
        if(job!=null){
            return new ResponseEntity<Job>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean flag = jobService.deleteJobById(id);
        if(flag){
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean flag = jobService.updateJobByID(id,updatedJob);
        if(flag){
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
