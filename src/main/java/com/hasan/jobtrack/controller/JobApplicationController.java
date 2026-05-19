package com.hasan.jobtrack.controller;

import com.hasan.jobtrack.dto.*;
import com.hasan.jobtrack.model.*;
import com.hasan.jobtrack.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {
    private final JobApplicationService service;
    public JobApplicationController(JobApplicationService service){ this.service=service; }
    @GetMapping public List<JobApplication> getAll(){ return service.getAll(); }
    @GetMapping("/{id}") public JobApplication getById(@PathVariable Long id){ return service.getById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public JobApplication create(@Valid @RequestBody JobApplicationRequest request){ return service.create(request); }
    @PutMapping("/{id}") public JobApplication update(@PathVariable Long id, @Valid @RequestBody JobApplicationRequest request){ return service.update(id, request); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){ service.delete(id); }
    @GetMapping("/search") public List<JobApplication> search(@RequestParam String company){ return service.search(company); }
    @GetMapping("/status/{status}") public List<JobApplication> byStatus(@PathVariable ApplicationStatus status){ return service.byStatus(status); }
    @GetMapping("/stats") public ApplicationStatsResponse stats(){ return service.stats(); }
}
