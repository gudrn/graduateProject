package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AttendanceView;
import com.example.demo.model.AttendanceViewImportClass;
import com.example.demo.model.MainBoolean;
import com.example.demo.model.MainString;
import com.example.demo.model.RandomKey;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.LectureService;
import com.example.demo.service.RandomKeyService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentLoginController {

	private final StudentService studentservic;
	private final LectureService lectureservic;
	private final RandomKeyService randomkeyservice;
	private final AttendanceService attendanceService;
	

	public StudentLoginController(StudentService studentservic, LectureService lectureservic,
			RandomKeyService randomkeyservice, AttendanceService attendanceService) {
		
		this.studentservic = studentservic;
		this.lectureservic = lectureservic;
		this.randomkeyservice = randomkeyservice;
		this.attendanceService = attendanceService;

	}

	@GetMapping("/login")//TODO: BOOL 하나 담는 클래스 하나 필요 
	public MainBoolean LoginUser(@RequestParam("id") String id) {

		MainBoolean mainboolean = new MainBoolean(false);
		if (studentservic.getStudentId(id) != null)// 학생일 경우
		{
			mainboolean.setBol(true);
			return mainboolean;
		}
		return mainboolean;// 학생 아닐 경우
		
	}

	@GetMapping("/attendlist")//TODO: BOOL 하나 담는 클래스 하나 필요 
	public MainString currentattendlist(@RequestParam("studentid") String studentid) {
		
		MainString mainstring=new MainString(null);
		mainstring.setStr(lectureservic.LetureByTIME(studentid));
		return mainstring;
		
	}

	// TODO 클래스 변경 (강의명, 출석, 출석 체크 시간, 날짜)
	@PostMapping("/attend")
	public AttendanceView attend(@RequestBody AttendanceViewImportClass AVIC) {
		
		String studentid= AVIC.getStudentid();
		String code=AVIC.getCode();
		
		String lecturecode=lectureservic.LectureByCode(studentid);
		if(lecturecode.isEmpty()) {
			return new AttendanceView(null);
		}
		RandomKey rk=randomkeyservice.getLectureRk(lecturecode);
		String lecturename=lectureservic.LetureByTIME(studentid);
		if(rk==null)return new AttendanceView(null);
		if (rk.getRandomKey().equals(code)) 
		{
			attendanceService.updateAttendance(studentid, lecturecode, true);
			AttendanceView attendanceview= new AttendanceView();
			attendanceview.setAttendance(true);
			attendanceview.setLecturename(lecturename);
			return attendanceview;
		}

		return new AttendanceView(null);

	}
}
