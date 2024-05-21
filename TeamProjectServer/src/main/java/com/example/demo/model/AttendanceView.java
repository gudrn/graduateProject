package com.example.demo.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;

//클래스 (강의명, 출석, 출석 체크 시간, 날짜)
public class AttendanceView {
	private String lecturename;
	private Boolean attendance;
	private String attendancetime;
	private String nowtime;
	
	public AttendanceView() {
		super();
		LocalDate now = LocalDate.now();
		this.nowtime= now.toString();
		
		Calendar calendar = Calendar.getInstance();
		long millis = calendar.getTimeInMillis();
		Time currentTime = new Time(millis);
		Time newcurrent = Time.valueOf(currentTime.toString());
		
		this.attendancetime=newcurrent.toString();
	}

	public AttendanceView(Object object) {
		
		super();
		this.lecturename=null;
		this.attendance=null;
		this.attendancetime=null;
		this.nowtime=null;
		
	}

	public String getLecturename() {
		return lecturename;
	}

	public void setLecturename(String lecturename) {
		this.lecturename = lecturename;
	}

	public Boolean getAttendance() {
		return attendance;
	}

	public void setAttendance(Boolean attendance) {
		this.attendance = attendance;
	}

	public String getAttendancetime() {
		return attendancetime;
	}

	public void setAttendancetime(String attendancetime) {
		this.attendancetime = attendancetime;
	}

	public String getNowtime() {
		return nowtime;
	}

	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}
	
	
}
