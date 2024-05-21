package com.example.demo.model;

public class Attendance {
    private String studentId;
    private String lectureCode;
    private Boolean attendance;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}
	public Boolean getAttendance() {
		return attendance;
	}
	public void setAttendance(Boolean attendance) {
		this.attendance = attendance;
	}

}
