package com.hasan.jobtrack.service;

import com.hasan.jobtrack.dto.ApplicationStatsResponse;
import com.hasan.jobtrack.dto.JobApplicationRequest;
import com.hasan.jobtrack.model.ApplicationStatus;
import com.hasan.jobtrack.model.JobApplication;
import com.hasan.jobtrack.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobApplicationService {
    private final JobApplicationRepository repo;
    public JobApplicationService(JobApplicationRepository repo){ this.repo=repo; }
    public List<JobApplication> getAll(){ return repo.findAll(); }
    public JobApplication getById(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Application not found with id: " + id)); }
    public JobApplication create(JobApplicationRequest r){ return repo.save(new JobApplication(r.getCompany(), r.getPosition(), r.getLocation(), r.getSalaryRange(), r.getStatus(), r.getAppliedDate(), r.getNotes())); }
    public JobApplication update(Long id, JobApplicationRequest r){ JobApplication a=getById(id); a.setCompany(r.getCompany()); a.setPosition(r.getPosition()); a.setLocation(r.getLocation()); a.setSalaryRange(r.getSalaryRange()); a.setStatus(r.getStatus()); a.setAppliedDate(r.getAppliedDate()); a.setNotes(r.getNotes()); return repo.save(a); }
    public void delete(Long id){ if(!repo.existsById(id)) throw new RuntimeException("Application not found with id: " + id); repo.deleteById(id); }
    public List<JobApplication> search(String company){ return repo.findByCompanyContainingIgnoreCase(company); }
    public List<JobApplication> byStatus(ApplicationStatus status){ return repo.findByStatus(status); }
    public ApplicationStatsResponse stats(){ return new ApplicationStatsResponse(repo.count(), repo.countByStatus(ApplicationStatus.SAVED), repo.countByStatus(ApplicationStatus.APPLIED), repo.countByStatus(ApplicationStatus.INTERVIEW), repo.countByStatus(ApplicationStatus.OFFER), repo.countByStatus(ApplicationStatus.REJECTED)); }
}
