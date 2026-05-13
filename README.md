# Yageum Backend

야금(Ya-Geum) 가계부 앱의 Spring Boot 백엔드 연습 프로젝트입니다.

## 🛠 기술 스택

- Java 22
- Spring Boot 4.0.6
- Spring Data JPA
- MySQL 9.0.1
- Lombok
- Gradle

## 📁 프로젝트 구조

```
src/main/java/com/yageum/backend/
└── domain/
    ├── controller/   # HTTP 요청/응답 처리
    ├── service/      # 비즈니스 로직
    ├── repository/   # DB 쿼리
    ├── entity/       # DB 테이블 매핑
    └── dto/          # 요청/응답 데이터 그릇
```

## 📌 API 목록

### 거래내역
| Method | URL | 설명 |
|--------|-----|------|
| GET | /api/transactions | 전체 조회 |
| GET | /api/transactions/user/{userId} | 유저별 조회 |
| POST | /api/transactions | 추가 |
| PUT | /api/transactions/{id} | 수정 |
| DELETE | /api/transactions/{id} | 삭제 |

### 유저
| Method | URL | 설명 |
|--------|-----|------|
| GET | /api/users | 전체 조회 |
| POST | /api/users | 추가 |
| GET | /api/users/{id} | 단건 조회 |
| PUT | /api/users/{id} | 수정 |
| DELETE | /api/users/{id} | 삭제 |

### 챌린지
| Method | URL | 설명 |
|--------|-----|------|
| POST | /api/challenges | 추가 |
| GET | /api/challenges/{id} | 조회 |
| PUT | /api/challenges/{id} | 수정 |
| DELETE | /api/challenges/{id} | 삭제 |

### 유저 챌린지
| Method | URL | 설명 |
|--------|-----|------|
| POST | /api/user-challenges | 챌린지 참여 |
| GET | /api/user-challenges/user/{userId} | 내 챌린지 목록 |
| PUT | /api/user-challenges/{id} | 상태 업데이트 |

## ⚙️ 실행 방법

1. MySQL에서 스키마 생성
```sql
CREATE DATABASE yageum;
```

2. `application.properties` 설정
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/yageum?serverTimezone=Asia/Seoul
spring.datasource.username=root
spring.datasource.password=비밀번호
```

3. IntelliJ에서 `BackendApplication.java` 실행

4. `http://localhost:8080` 접속 확인
