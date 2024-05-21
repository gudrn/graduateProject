package com.example.demo.service;

import com.example.demo.mapper.LectureMapper;
import com.example.demo.model.Lecture;
import com.example.demo.model.Lecture2;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class LectureService {
    private final LectureMapper lectureMapper;

    public LectureService(LectureMapper lectureMapper) {
        this.lectureMapper = lectureMapper;
    }

    // 강의 추가
    public int addLecture(Lecture lecture) {
        return lectureMapper.insertLecture(lecture);
    }

    // 강의 코드에 따른 강의 조회
    public Lecture getLectureByCode(String lectureCode) {
        return lectureMapper.selectLectureByCode(lectureCode);
    }
    
    public List<Lecture2> getLectureByprofessorid(String ProfessorID){
    	List<Lecture> a=lectureMapper.selectListbyPID(ProfessorID);
    	List<Lecture2> b = new ArrayList<>();
    	for(Lecture k:a) {
    		SimpleDateFormat fromat=new SimpleDateFormat("HH:mm:ss");
    		String start=fromat.format(k.getStartTime());
    		String end=fromat.format(k.getEndTime());
    		b.add(new Lecture2(k.getLectureCode(),k.getLectureName(),k.getProfessorId(),start,end));
    	}
    	return b;
    }

    // 모든 강의 조회
    public List<Lecture> getAllLectures() {
        return lectureMapper.selectAllLectures();
    }

    // 강의 정보 업데이트
    public int updateLecture(Lecture lecture) {
        return lectureMapper.updateLecture(lecture);
    }

    // 강의 코드에 따른 강의 삭제
    public int deleteLectureByCode(String lectureCode) {
        return lectureMapper.deleteLectureByCode(lectureCode);
    }
    
    public String LetureByTIME(String studentid) {
    	return lectureMapper.selectLectureByTIME(studentid);
    }
    
    public String LectureByCode(String studentid) {
    	return lectureMapper.selectLecture(studentid);
    }
}
