package com.example.demo.model;

import java.sql.Timestamp;

public class RandomKey {
	private Integer randomKeyId;
    private String lectureCode;
    private String randomKey;
    private Boolean used;
    private Timestamp createdAt;
    
	public Integer getRandomKeyId() {
		return randomKeyId;
	}
	public void setRandomKeyId(Integer randomKeyId) {
		this.randomKeyId = randomKeyId;
	}
	public String getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}
	public String getRandomKey() {
		return randomKey;
	}
	public void setRandomKey(String randomKey) {
		this.randomKey = randomKey;
	}
	public Boolean getUsed() {
		return used;
	}
	public void setUsed(Boolean used) {
		this.used = used;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
    
    
    
}