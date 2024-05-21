package com.example.demo.service;

import com.example.demo.mapper.ProfessorMapper;
import com.example.demo.model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorMapper professorMapper) {
        this.professorMapper = professorMapper;
    }

    public int addProfessor(Professor professor) {
        return professorMapper.insertProfessor(professor);
    }

    public Professor getProfessorId(String professorId) {
        return professorMapper.selectProfessorById(professorId);
    }

    public List<Professor> getAllProfessors() {
        return professorMapper.selectAllProfessors();
    }

    public int updateProfessor(Professor professor) {
        return professorMapper.updateProfessor(professor);
    }

    public int deleteProfessorById(String professorId) {
        return professorMapper.deleteProfessorById(professorId);
    }
}
