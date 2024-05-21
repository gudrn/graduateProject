package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO students(studentid, name) VALUES(#{studentid}, #{name})")
    int insertStudent(Student student);

    @Select("SELECT * FROM students WHERE studentid = #{studentId}")
    Student selectStudentId(String studentId);

    @Select("SELECT * FROM students")
    List<Student> selectAllStudents();

    @Update("UPDATE students SET name = #{name} WHERE studentid = #{studentId}")
    int updateStudent(Student student);

    @Delete("DELETE FROM students WHERE studentid = #{studentId}")
    int deleteStudentId(String studentId);
}
