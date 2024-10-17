package com.example.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job,Integer> {
    @Query("select j from Job j where j.service=:ser")
    Job findByNom(@Param("ser")String nom);

}
