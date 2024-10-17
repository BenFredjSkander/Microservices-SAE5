package com.example.job;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class JobService {
    @Autowired
    private JobRepository jobRepository;
    public Job addJob(Job job){return jobRepository.save(job);}

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
    public Job getJob(int id){
        return jobRepository.findById(id).orElse(null);
    }
    public Job getJobByName(String name){
        return jobRepository.findByNom(name);
    }
    public boolean changeEtat(int id,boolean etat){
        Job job=jobRepository.findById(id).orElse(null);
        job.setEtat(etat);
        jobRepository.save(job);
        return etat;
    }



}
