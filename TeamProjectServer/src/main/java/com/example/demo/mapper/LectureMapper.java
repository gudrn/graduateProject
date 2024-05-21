package com.example.demo.mapper;

import com.example.demo.model.Lecture;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LectureMapper {
    @Insert("INSERT INTO lectures(lecturename, professorid, professorid) VALUES(#{lectureCode}, #{lectureName},#{ProfessorID})")
    int insertLecture(Lecture lecture);

    @Select("SELECT * FROM lectures WHERE lecturecode = #{lectureCode}")
    Lecture selectLectureByCode(String lectureCode);

    @Select("SELECT * FROM lectures")
    List<Lecture> selectAllLectures();

    @Select("SELECT * FROM lectures WHERE professorid=#{ProfessorID}")
    List<Lecture> selectListbyPID(String ProfessorID);
    
    @Update("UPDATE lectures SET lecturename = #{lectureName} WHERE lecturecode = #{lectureCode}")
    int updateLecture(Lecture lecture);

    @Delete("DELETE FROM lectures WHERE lecturecode = #{lectureCode}")
    int deleteLectureByCode(String lectureCode);
    
    @Select("SELECT l.lecturename FROM lectures l JOIN enrollments e ON l.lecturecode = e.lecturecode WHERE CURTIME() BETWEEN l.startTime AND l.endTime AND e.studentid = #{StudentID}")
    String selectLectureByTIME(String StudentID);
    
    @Select("SELECT l.lecturecode FROM lectures l JOIN enrollments e ON l.lecturecode = e.lecturecode WHERE CURTIME() BETWEEN l.startTime AND l.endTime AND e.studentid = #{StudentID}")
    String selectLecture(String StudentID);
}
