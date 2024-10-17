package com.example.job;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("job")


public class JobRestApi {
    @Autowired
    private JobService jobService;
    @PostMapping("save")
    public Job  createJob(@RequestBody Job job){return jobService.addJob(job);}


    @GetMapping("all")
    public ResponseEntity<List<Job>> getJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }
    @GetMapping("byID/{id}")
    public ResponseEntity<Job> getJob(@PathVariable int id) {
        return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
    }
    @GetMapping("/{service}")
    public ResponseEntity<Job> getJobByNom(@PathVariable String service) {
        return new ResponseEntity<>(jobService.getJobByName(service), HttpStatus.OK);
    }
    @PostMapping("/{id}/{etat}")
    public boolean changeJobEtat(@PathVariable int id,@PathVariable boolean etat){
        return jobService.changeEtat(id,etat);
    }




}
