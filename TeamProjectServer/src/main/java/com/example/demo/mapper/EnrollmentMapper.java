package com.example.demo.mapper;

import com.example.demo.model.Enrollment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnrollmentMapper {
    @Insert("INSERT INTO enrollments(studentid, lectureCode) VALUES(#{studentId}, #{lectureCode})")
    int insertEnrollment(Enrollment enrollment);

    @Select("SELECT * FROM enrollments WHERE enrollmentid = #{enrollmentId}")
    Enrollment selectEnrollmentById(int enrollmentId);
    
    @Select("SELECT * FROM enrollments WHERE Studentid = #{StudentID}")
    List<Enrollment> selectEnrollmentBySid(String StudentID);

    @Select("SELECT * FROM enrollments")
    List<Enrollment> selectAllEnrollments();

    @Update("UPDATE enrollments SET studentid = #{studentId}, lectureCode = #{lectureCode} WHERE enrollmentid = #{enrollmentId}")
    int updateEnrollment(Enrollment enrollment);

    @Delete("DELETE FROM enrollments WHERE enrollmentid = #{enrollmentId}")
    int deleteEnrollmentById(int enrollmentId);
}
