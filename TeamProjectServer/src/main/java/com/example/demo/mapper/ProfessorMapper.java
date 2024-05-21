package com.example.demo.mapper;

import com.example.demo.model.Professor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProfessorMapper {
    @Insert("INSERT INTO professors(professorid, name, department) VALUES(#{professorId}, #{name}, #{department})")
    int insertProfessor(Professor professor);

    @Select("SELECT * FROM professors WHERE professorid = #{professorId}")
    Professor selectProfessorById(String professorId);

    @Select("SELECT * FROM professors")
    List<Professor> selectAllProfessors();

    @Update("UPDATE professors SET name = #{name}, department = #{department} WHERE professorid = #{professorId}")
    int updateProfessor(Professor professor);

    @Delete("DELETE FROM professors WHERE professorid = #{professorId}")
    int deleteProfessorById(String professorId);
}
