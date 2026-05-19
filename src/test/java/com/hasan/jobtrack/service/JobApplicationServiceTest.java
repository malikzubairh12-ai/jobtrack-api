package com.hasan.jobtrack.service;

import com.hasan.jobtrack.dto.JobApplicationRequest;
import com.hasan.jobtrack.model.JobApplication;
import com.hasan.jobtrack.repository.JobApplicationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JobApplicationServiceTest {
    @Test
    void create_shouldSaveApplication(){
        JobApplicationRepository repo = Mockito.mock(JobApplicationRepository.class);
        when(repo.save(any(JobApplication.class))).thenAnswer(inv -> inv.getArgument(0));
        JobApplicationService service = new JobApplicationService(repo);
        JobApplicationRequest r = new JobApplicationRequest(); r.setCompany("SAP"); r.setPosition("Werkstudent Java");
        JobApplication saved = service.create(r);
        assertEquals("SAP", saved.getCompany()); verify(repo, times(1)).save(any(JobApplication.class));
    }
    @Test
    void getById_shouldThrowWhenMissing(){
        JobApplicationRepository repo = Mockito.mock(JobApplicationRepository.class);
        when(repo.findById(1L)).thenReturn(Optional.empty());
        JobApplicationService service = new JobApplicationService(repo);
        assertThrows(RuntimeException.class, () -> service.getById(1L));
    }
}
