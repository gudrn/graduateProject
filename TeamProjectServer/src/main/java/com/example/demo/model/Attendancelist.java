package com.example.demo.model;

public class Attendancelist {

	private String studentId;
    private String name;
    private Boolean attendance;
    
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Boolean getAttendance() {
		return attendance;
	}
	public void setAttendance(Boolean attendance) {
		this.attendance = attendance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
