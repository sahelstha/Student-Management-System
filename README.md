# Student Management System

A comprehensive Spring Boot application for managing students, courses, and course enrollments. This project demonstrates modern Java enterprise development practices with two different implementation approaches: one using **JPA (Java Persistence API)** and another using **pure JDBC** without ORM.

## 🎯 Overview

The Student Management System is a full-featured REST API built with Spring Boot 4.0.2 that enables educational institutions to manage their students and course catalogs efficiently. The system provides secure access with Spring Security and supports multiple implementation patterns for data persistence.

## ✨ Features

- **Student Management**: Create, read, update, and delete student records with personal details (name, date of birth, email)
- **Course Management**: Manage course offerings with descriptions and course details
- **Enrollment System**: Track student enrollments in courses with a many-to-many relationship
- **Dual Implementation Approaches**: 
  - **JPA Implementation**: Using Spring Data JPA with automatic entity mapping
  - **JDBC Implementation**: Custom SQL queries for direct database control
- **Security**: Spring Security integration for authentication and authorization
- **H2 Database**: Embedded in-memory database for easy setup and testing
- **REST API**: Full REST endpoints for all operations
- **HATEOAS Support**: Hypermedia support for RESTful API responses

## 🛠️ Technology Stack

- **Framework**: Spring Boot 4.0.2
- **Language**: Java 17
- **Database**: H2 Database (in-memory)
- **ORM**: Spring Data JPA (optional implementation)
- **Security**: Spring Security
- **Build Tool**: Maven
- **API Style**: REST with HATEOAS
- **Testing**: Spring Security Test, WebMvc Test

## 📋 Project Structure

```
src/main/java/com/StudentManagementSystem/
├── withJpa/                      # JPA-based implementation
│   ├── controller/               # REST controllers
│   ├── service/                  # Business logic
│   ├── entities/                 # JPA entities
│   ├── repository/               # Spring Data repositories
│   └── security/                 # Security configuration
├── withoutJpa/                   # JDBC-based implementation
│   ├── controller/               # REST controllers
│   ├── service/                  # Business logic
│   ├── entities/                 # Plain Java classes
│   └── security/                 # Security configuration
└── StudentManagementApplication.java  # Main application class

src/main/resources/
├── application.properties         # Application configuration
└── data.sql                      # Sample data initialization
```

## 🏗️ Core Entities

### Student
- **ID**: Auto-generated sequence (starting from 10001)
- **Name**: Student's full name
- **Date of Birth**: Student's birth date
- **Email**: Contact email
- **Enrollments**: One-to-many relationship with courses

### Course
- **ID**: Auto-generated sequence (starting from 1001)
- **Course Name**: Name of the course
- **Course Description**: Detailed description
- **Enrollments**: One-to-many relationship with students

### Enrollment
- **Student ID**: Foreign key to Student
- **Course ID**: Foreign key to Course
- Represents the many-to-many relationship between students and courses

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.0 or higher

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/StudentManagementSystem.git
   cd StudentManagementSystem
   ```

2. **Build the Project**
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`

### Default Credentials
- **Username**: `sahel`
- **Password**: `test`

## 📡 API Endpoints

### Student Endpoints
- `GET /students` - Retrieve all students
- `GET /students/{id}` - Get a specific student
- `POST /students` - Create a new student
- `PUT /students/{id}` - Update a student
- `DELETE /students/{id}` - Delete a student

### Course Endpoints
- `GET /courses` - Retrieve all courses
- `GET /courses/{id}` - Get a specific course
- `POST /courses` - Create a new course
- `PUT /courses/{id}` - Update a course
- `DELETE /courses/{id}` - Delete a course

### Enrollment Endpoints
- `GET /enrollments` - Retrieve all enrollments
- `POST /enrollments` - Enroll a student in a course
- `DELETE /enrollments/{id}` - Remove an enrollment

## 🔐 Security

The application uses Spring Security for authentication and authorization. By default, it's configured with:
- Basic authentication
- Default user credentials in `application.properties`
- Easy to extend for JWT or OAuth2 implementation

## 💾 Database

### H2 Console
Access the H2 database console at: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:test`
- Username: `sa`
- Password: (leave blank)

### Sample Data
The application initializes with sample data:
- 4 students (Sahel, hello, ram, hehe)
- 4 courses (Spring, Database, JavaScript, Python)
- 10 enrollments showing student-course relationships

## 🔄 Implementation Approaches

### JPA Implementation (`withJpa` package)
- Uses Spring Data JPA for automatic database operations
- Repositories extend `JpaRepository`
- Automatic query generation
- Best for rapid development and less boilerplate
- Located in: `src/main/java/com/StudentManagementSystem/withJpa/`

### JDBC Implementation (`withoutJpa` package)
- Uses raw JDBC for full control over queries
- Custom SQL queries
- Better for complex operations and performance optimization
- Good for learning JDBC concepts
- Located in: `src/main/java/com/StudentManagementSystem/withoutJpa/`


## 🎓 Learning Resources

This project is ideal for:
- Learning Spring Boot fundamentals
- Understanding
- Exploring JDBC alternatives
- Building REST APIs
- Implementing security in Spring applications
- Database relationship modeling (One-to-Many, Many-to-Many)

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 👤 Author

Created as a demonstration project for Spring Boot and enterprise Java development.

## 📞 Support

For issues, questions, or suggestions, please open an issue on GitHub.

---

**Happy Learning!** 🎉
