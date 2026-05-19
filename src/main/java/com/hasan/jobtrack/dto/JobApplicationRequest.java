package com.hasan.jobtrack.dto;

import com.hasan.jobtrack.model.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class JobApplicationRequest {
    @NotBlank(message="Company is required") private String company;
    @NotBlank(message="Position is required") private String position;
    private String location;
    private String salaryRange;
    private ApplicationStatus status;
    private LocalDate appliedDate;
    @Size(max=1000, message="Notes must be max 1000 characters") private String notes;
    public String getCompany(){return company;} public void setCompany(String company){this.company=company;}
    public String getPosition(){return position;} public void setPosition(String position){this.position=position;}
    public String getLocation(){return location;} public void setLocation(String location){this.location=location;}
    public String getSalaryRange(){return salaryRange;} public void setSalaryRange(String salaryRange){this.salaryRange=salaryRange;}
    public ApplicationStatus getStatus(){return status;} public void setStatus(ApplicationStatus status){this.status=status;}
    public LocalDate getAppliedDate(){return appliedDate;} public void setAppliedDate(LocalDate appliedDate){this.appliedDate=appliedDate;}
    public String getNotes(){return notes;} public void setNotes(String notes){this.notes=notes;}
}
