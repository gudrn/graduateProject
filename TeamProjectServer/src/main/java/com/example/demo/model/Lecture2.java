package com.example.demo.model;

import java.sql.Time;

public class Lecture2 {
    private String lectureCode;
    private String lectureName;
    private String professorId;
    private String startTime;//요부분 
    private String endTime;

	public Lecture2(String lectureCode, String lectureName, String professorId, String startTime, String endTime) {
		super();
		this.lectureCode = lectureCode;
		this.lectureName = lectureName;
		this.professorId = professorId;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getLectureCode() {
        return lectureCode;
    }

    public void setLectureCode(String lectureCode) {
        this.lectureCode = lectureCode;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
