# Task Manager Application

This is a simple full-stack task management application built using Spring Boot, React, and MySQL.  
The purpose of this project is to demonstrate backend API development, frontend integration, and database persistence.

---

## Tech Stack

**Backend:**
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

**Frontend:**
- React
- JavaScript
- HTML / CSS

---

## Features

- User registration
- User login
- Create, view, update, and delete tasks
- RESTful API design
- MySQL database integration
- Frontend and backend communication using HTTP requests

---

## Backend Setup

1. Create a MySQL database:
CREATE DATABASE task_manager;

2. Update application.properties with your database credentials.

3. Run the backend using NetBeans or via terminal:
mvn spring-boot:run

Backend runs on:
http://localhost:8080

## Frontend Setup

1. Navigate to the frontend directory.

2. Install dependencies:
npm install

3. Start the frontend:
npm start

Frontend runs on:
http://localhost:3000

## API Endpoints

1. User:
   - POST /users/register
   - POST /users/login

2. Tasks:
   - GET /tasks
   - POST /tasks
   - PUT /tasks/{id}
   - DELETE /tasks/{id}
