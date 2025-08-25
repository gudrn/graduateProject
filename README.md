# 출석 관리 시스템 (Attendance Management System)

## 프로젝트 개요
이 프로젝트는 대학교 강의 출석을 관리하는 Spring Boot 기반의 웹 애플리케이션입니다. 교수와 학생이 각각 다른 역할을 수행하며, 실시간으로 출석을 체크할 수 있는 시스템입니다.

## 📱 앱 스크린샷

### 로그인 화면
![로그인 화면](images/로그인%20화면.png)

### 수강중인 강의 화면
![수강중인 강의 화면](images/수강중인%20강의%20화면.png)

### 출석 화면
![출석 화면](images/출석%20화면.png)

### 출석 화면 (수업중)
![출석 화면_수업중](images/출석%20화면%20수음중.png)

## 기술 스택
- **Backend**: Spring Boot 3.2.3
- **Java Version**: 17
- **Database**: MySQL
- **ORM**: MyBatis
- **Build Tool**: Maven
- **Server Port**: 5000

## 주요 기능

### 교수 기능
- 교수 로그인 및 인증
- 담당 강의 목록 조회
- 강의별 출석 현황 조회
- 실시간 출석 체크 시작 (랜덤 키 생성)

### 학생 기능
- 학생 로그인 및 인증
- 현재 수강 중인 강의 목록 조회
- 랜덤 키를 통한 출석 체크
- 출석 결과 확인

## 프로젝트 구조

```
TeamProjectServer/
├── src/main/java/com/example/demo/
│   ├── controller/          # REST API 컨트롤러
│   │   ├── ProfessorLoginController.java    # 교수 관련 API
│   │   └── StudentLoginController.java      # 학생 관련 API
│   ├── model/               # 데이터 모델 클래스
│   │   ├── Student.java     # 학생 정보
│   │   ├── Professor.java   # 교수 정보
│   │   ├── Lecture.java     # 강의 정보
│   │   ├── Attendance.java  # 출석 정보
│   │   └── ...
│   ├── service/             # 비즈니스 로직 서비스
│   │   ├── StudentService.java
│   │   ├── ProfessorService.java
│   │   ├── LectureService.java
│   │   ├── AttendanceService.java
│   │   └── RandomKeyService.java
│   ├── mapper/              # MyBatis 매퍼 인터페이스
│   └── TeamProjectServerApplication.java    # 메인 애플리케이션
├── src/main/resources/
│   └── application.properties    # 데이터베이스 설정
└── pom.xml                      # Maven 의존성 관리
```

## 데이터베이스 설정

### MySQL 연결 정보
- **URL**: jdbc:mysql://127.0.0.1:3306/attenddb
- **Username**: root1
- **Password**: 1234
- **Port**: 5000

### 서버 설정
- 최대 스레드: 16
- 최소 스레드: 2
- 최대 연결: 8192
- 연결 타임아웃: 20초

## API 엔드포인트

### 교수 API (`/professor`)
- `GET /professor/login` - 교수 로그인
- `GET /professor/lecturelist` - 교수 강의 목록
- `GET /professor/lecture` - 강의별 출석 현황
- `GET /professor/attendance` - 출석 체크 시작

### 학생 API (`/student`)
- `GET /student/login` - 학생 로그인
- `GET /student/attendlist` - 학생 수강 강의 목록
- `POST /student/attend` - 출석 체크

## 핵심 모델

### Student (학생)
- `studentId`: 학생 ID
- `name`: 학생 이름

### Professor (교수)
- `id`: 교수 ID
- `name`: 교수 이름
- `department`: 소속 학과

### Lecture (강의)
- `lectureCode`: 강의 코드
- `lectureName`: 강의명
- `professorId`: 담당 교수 ID
- `startTime`: 강의 시작 시간
- `endTime`: 강의 종료 시간

### Attendance (출석)
- `studentId`: 학생 ID
- `lectureCode`: 강의 코드
- `attendance`: 출석 여부 (Boolean)

## 출석 체크 프로세스

1. **교수가 출석 체크 시작**
   - 강의 시간대 확인
   - 랜덤 키 생성 및 저장

2. **학생이 출석 체크**
   - 랜덤 키 입력
   - 키 일치 시 출석 처리
   - 출석 결과 반환

## 실행 방법

### 사전 요구사항
- Java 17 이상
- MySQL 8.0 이상
- Maven 3.6 이상

### 실행 단계
1. MySQL 데이터베이스 생성 및 설정
2. `application.properties` 파일의 데이터베이스 정보 수정
3. 프로젝트 루트 디렉토리에서 다음 명령어 실행:
   ```bash
   mvn spring-boot:run
   ```

### 빌드
```bash
mvn clean package
```

## 개발 환경 설정

### IDE 설정
- IntelliJ IDEA 또는 Eclipse 권장
- Spring Boot 플러그인 설치
- Lombok 플러그인 설치 (필요시)

### 데이터베이스 스키마
프로젝트 실행 전 다음 테이블들이 생성되어야 합니다:
- `student` - 학생 정보
- `professor` - 교수 정보
- `lecture` - 강의 정보
- `attendance` - 출석 정보
- `random_key` - 랜덤 키 정보

## 라이선스
이 프로젝트는 교육 목적으로 개발되었습니다.

## 기여 방법
1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


