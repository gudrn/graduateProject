package com.example.demo.service;

import com.example.demo.mapper.EnrollmentMapper;
import com.example.demo.model.Enrollment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentMapper enrollmentMapper;

    public EnrollmentService(EnrollmentMapper enrollmentMapper) {
        this.enrollmentMapper = enrollmentMapper;
    }

    public int addEnrollment(Enrollment enrollment) {
        return enrollmentMapper.insertEnrollment(enrollment);
    }

    public Enrollment getEnrollmentId(int enrollmentId) {
        return enrollmentMapper.selectEnrollmentById(enrollmentId);
    }
    
    public List<Enrollment> getEnrollmentSid(String studentid) {
        return enrollmentMapper.selectEnrollmentBySid(studentid);
    }

    public List<Enrollment> getallEnrollments() {
        return enrollmentMapper.selectAllEnrollments();
    }

    public int updateEnrollment(Enrollment enrollment) {
        return enrollmentMapper.updateEnrollment(enrollment);
    }

    public int deleteEnrollmentId(int enrollmentId) {
        return enrollmentMapper.deleteEnrollmentById(enrollmentId);
    }
}
