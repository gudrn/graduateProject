package com.example.demo.service;

import com.example.demo.mapper.AttendanceMapper;
import com.example.demo.model.Attendance;
import com.example.demo.model.Attendancelist;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    private final AttendanceMapper attendanceMapper;

    public AttendanceService(AttendanceMapper attendanceMapper) {
        this.attendanceMapper = attendanceMapper;
    }

    public void addAttendance(Attendance attendance) {
        attendanceMapper.insertAttendance(attendance);
    }

    public List<Attendance> getAttendanceByLectureCode(String lectureCode) {
        return attendanceMapper.getAttendanceByLectureCode(lectureCode);
    }

    public void updateAttendance(String studentId, String lectureCode, Boolean attendance) {
        attendanceMapper.updateAttendance(studentId, lectureCode, attendance);
    }

    public void deleteAttendance(Long attendId) {
        attendanceMapper.deleteAttendance(attendId);
    }

	public List<Attendancelist> getlist(String LectureCode){
		return attendanceMapper.getAttendanceList(LectureCode);
	}
}
