package com.example.demo.model;

public class AttendanceViewImportClass {
	
	private String studentid;
	private String code;
	
	public AttendanceViewImportClass(String studentid, String code) {
		super();
		this.studentid = studentid;
		this.code = code;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
