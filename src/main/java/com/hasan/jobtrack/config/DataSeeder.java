package com.hasan.jobtrack.config;

import com.hasan.jobtrack.model.*;
import com.hasan.jobtrack.repository.JobApplicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seed(JobApplicationRepository repo){ return args -> { if(repo.count()==0){ repo.save(new JobApplication("SAP", "Java Backend Werkstudent", "Walldorf", "16-20 EUR/h", ApplicationStatus.APPLIED, LocalDate.now().minusDays(2), "Applied with GitHub portfolio")); repo.save(new JobApplication("Bosch", "Software Engineering Intern", "Stuttgart", "15-18 EUR/h", ApplicationStatus.SAVED, null, "Prepare cover letter")); } }; }
}
