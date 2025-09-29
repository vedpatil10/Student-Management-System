## Student Management System (Java, SQL)

### Overview
A Java-based Student Management System to simplify managing student records. It supports secure role-based access, student registration and updates, fast search, and report generation. Data is persisted in a relational database (SQL), showcasing practical Java and database skills.

### Key Features
- Registration, update, and deletion of student records
- Role-based authentication and authorization (Admin, Staff, Viewer)
- Quick search by name, roll number, course, or status
- Course and enrollment management
- Attendance and grades recording (optional module)
- Reports: student list, attendance, grades, enrollments (CSV/PDF)
- Input validation and audit logging

### Tech Stack
- Java 11+ (recommended Java 17)
- Build: Maven or Gradle
- Database: MySQL or PostgreSQL
- JDBC/HikariCP (or JPA/Hibernate optional)
- Authentication: role-based (DAO-backed)
- Packaging: jar (CLI/Desktop) or war (if web)

### Architecture
- Layered design: `controller` → `service` → `repository` → `database`
- DTOs for input/output, Entities for persistence
- Centralized exception handling and validation utilities
- Config-driven DB and app settings (`application.properties`)

### Database Schema (minimal)
Tables (example names):
- `students(id, roll_no, first_name, last_name, dob, email, phone, address, status, created_at, updated_at)`
- `courses(id, code, name, credits, created_at, updated_at)`
- `enrollments(id, student_id, course_id, enrolled_on, grade)`
- `users(id, username, password_hash, role, created_at)`
- `audit_logs(id, user_id, action, entity, entity_id, created_at)`

Indexes: `students(roll_no)`, `students(last_name)`, `courses(code)`, foreign keys on `enrollments`.

### Getting Started
1) Prerequisites
- Install Java 11+ and Maven (or Gradle)
- Install MySQL or PostgreSQL and create a database (e.g., `student_mgmt`)

2) Configure DB
Create `src/main/resources/application.properties`:
```
db.url=jdbc:mysql://localhost:3306/student_mgmt?useSSL=false&serverTimezone=UTC
db.username=your_user
db.password=your_password
db.pool.size=10
```

3) Build
```
mvn clean package
# or
gradle clean build
```

4) Run
```
java -jar target/student-management-system.jar
```

### Role-Based Access
- Admin: full CRUD for students/courses/users, reports
- Staff: manage students/enrollments, read reports
- Viewer: read-only access to student and course data

### Typical Use Flows
1. Admin creates courses and users
2. Staff registers students and enrolls them in courses
3. Staff updates records, attendance, grades
4. Users search and generate reports

### Validation & Security
- Strong input validation (email/phone/date formats)
- Parameterized queries/ORM to prevent SQL injection
- Passwords stored as salted hashes (e.g., BCrypt/Argon2)
- Least-privilege DB user and role checks at service/controller

### Reports
- CSV/PDF exports (e.g., OpenCSV, iTextPDF)
- Filters by course, date range, status

### Testing
- Unit tests for services and repositories (JUnit 5, Mockito)
- Integration tests with test containers or in-memory DB (H2)

### Future Enhancements
- Web UI (Spring MVC/Thymeleaf or React)
- REST API (Spring Boot) for integrations
- Attendance and timetable modules
- Bulk import/export via Excel
- Caching and pagination for large datasets

### License
Use and modify for educational and portfolio purposes. Add a formal license if needed.


