package com.hasan.jobtrack.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class JobApplication {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String position;
    private String location;
    private String salaryRange;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private LocalDate appliedDate;
    private String notes;
    public JobApplication() {}
    public JobApplication(String company, String position, String location, String salaryRange, ApplicationStatus status, LocalDate appliedDate, String notes){ this.company=company; this.position=position; this.location=location; this.salaryRange=salaryRange; this.status=status; this.appliedDate=appliedDate; this.notes=notes; }
    @PrePersist public void prePersist(){ if(status==null) status=ApplicationStatus.SAVED; }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getCompany(){return company;} public void setCompany(String company){this.company=company;}
    public String getPosition(){return position;} public void setPosition(String position){this.position=position;}
    public String getLocation(){return location;} public void setLocation(String location){this.location=location;}
    public String getSalaryRange(){return salaryRange;} public void setSalaryRange(String salaryRange){this.salaryRange=salaryRange;}
    public ApplicationStatus getStatus(){return status;} public void setStatus(ApplicationStatus status){this.status=status;}
    public LocalDate getAppliedDate(){return appliedDate;} public void setAppliedDate(LocalDate appliedDate){this.appliedDate=appliedDate;}
    public String getNotes(){return notes;} public void setNotes(String notes){this.notes=notes;}
}
