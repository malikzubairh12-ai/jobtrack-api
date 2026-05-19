package com.hasan.jobtrack.repository;

import com.hasan.jobtrack.model.ApplicationStatus;
import com.hasan.jobtrack.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByCompanyContainingIgnoreCase(String company);
    List<JobApplication> findByStatus(ApplicationStatus status);
    long countByStatus(ApplicationStatus status);
}
