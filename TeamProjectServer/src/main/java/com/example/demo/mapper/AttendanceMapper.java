package com.example.demo.mapper;

import com.example.demo.model.Attendance;
import com.example.demo.model.Attendancelist;

import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AttendanceMapper {
    @Insert("INSERT INTO attend (studentid, lecturecode, attendance) VALUES (#{studentId}, #{lectureCode}, #{attendance})")
    @Options(useGeneratedKeys = true, keyProperty = "attendId")
    void insertAttendance(Attendance attendance);

    @Select("SELECT studentId, lectureCode, attendance FROM attend WHERE lecturecode = #{lecturecode}")
    List<Attendance> getAttendanceByLectureCode(@Param("lectureCode") String lectureCode);

    @Update("UPDATE attend SET attendance = #{attendance} WHERE studentid = #{studentId} AND lecturecode = #{lectureCode}")
    void updateAttendance(@Param("studentId") String studentId, @Param("lectureCode") String lectureCode, @Param("attendance") Boolean attendance);

    @Delete("DELETE FROM attend WHERE attendId = #{attendId}")
    void deleteAttendance(Long attendId);
    
    @Select("SELECT students.name, students.studentid, attend.attendance FROM students JOIN attend ON students.studentid = attend.studentid WHERE attend.lecturecode = #{lectureCode}")
    List<Attendancelist> getAttendanceList(@Param("lectureCode") String lectureCode);
	
}
