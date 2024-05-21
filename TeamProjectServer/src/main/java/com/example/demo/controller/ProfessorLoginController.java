package com.example.demo.controller;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Attendancelist;
import com.example.demo.model.Lecture;
import com.example.demo.model.Lecture2;
import com.example.demo.model.MainBoolean;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.LectureService;
import com.example.demo.service.ProfessorService;
import com.example.demo.service.RandomKeyService;

import com.example.demo.model.MainString;

@RestController
@RequestMapping("/professor")
public class ProfessorLoginController {

	private final ProfessorService professortservice;
	private final RandomKeyService randomkeyservice;
	private final LectureService lectureservic;
	private final AttendanceService attendanceService;

	public ProfessorLoginController(ProfessorService professortservice, RandomKeyService randomkeyservice,
			LectureService lectureservic, AttendanceService attendanceService) {
		super();
		this.professortservice = professortservice;
		this.randomkeyservice = randomkeyservice;
		this.lectureservic = lectureservic;
		this.attendanceService = attendanceService;
	}

	@GetMapping("/login")
	public MainBoolean LoginUser(@RequestParam("professorID") String id) {

		MainBoolean mainboolean = new MainBoolean(false);
		if (professortservice.getProfessorId(id) != null)// 교수일 경우
		{
			mainboolean.setBol(true);
			return mainboolean;
		}
		return mainboolean;// 교수 아닐 경우
	}

	@GetMapping("/lecturelist") // 교수 강의 리스트
	public List<Lecture2> getlist(@RequestParam("professorID") String professorID) {
		return lectureservic.getLectureByprofessorid(professorID);
	}

	@GetMapping("/lecture") // TODO 클래스 변경 (강의명, 출석, 출석 체크 시간, 날짜)
	public List<Attendancelist> getAttendanceByLectureCode(@RequestParam("lectureCode") String lectureCode) {
		
		List<Attendancelist> attendances = attendanceService.getlist(lectureCode);

		return attendances;
	}

	@GetMapping("/attendance") // get으로 변경
	public MainString attendance(@RequestParam("lectureCode") String lecturecode) {
		Calendar calendar = Calendar.getInstance();
		long millis = calendar.getTimeInMillis();
		Time currentTime = new Time(millis);
		Time newcurrent = Time.valueOf(currentTime.toString());
		MainString mainstring=new MainString(null);

		if (lectureservic.getLectureByCode(lecturecode) == null)
			return mainstring;

		// 시간대가 아니면 false
		if (!(newcurrent.after(lectureservic.getLectureByCode(lecturecode).getStartTime())
				&& newcurrent.before(lectureservic.getLectureByCode(lecturecode).getEndTime())))
			return mainstring;

		if (randomkeyservice.getLectureRk(lecturecode) != null) {
			mainstring.setStr(randomkeyservice.getLectureRk(lecturecode).getRandomKey());
			return mainstring;
		}

		String AttendRandomKey = randomkeyservice.makeRK();
		randomkeyservice.createAndStoreRandomKey(lecturecode, AttendRandomKey);

		mainstring.setStr(AttendRandomKey);
		return mainstring;
	}

}
