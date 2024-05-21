package com.example.demo.service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public int addStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    public Student getStudentId(String studentId) {
        return studentMapper.selectStudentId(studentId);
    }

    public List<Student> getallStudents() {
        return studentMapper.selectAllStudents();
    }

    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public int deleteStudentId(String studentId) {
        return studentMapper.deleteStudentId(studentId);
    }
    
    
}
