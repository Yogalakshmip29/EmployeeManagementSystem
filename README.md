Employee Management System

📌 Overview

This is a Spring Boot-based Employee Management System that manages employees, departments, addresses, projects, and tasks. The system supports various relationships, including:

One-to-One: Employee ↔ Address

One-to-Many: Department ↔ Employees, Project ↔ Tasks

Many-to-One: Employees ↔ Department, Tasks ↔ Project

Many-to-Many: Employees ↔ Projects

The project follows best practices for entity relationships, validation, and persistence using Spring Data JPA.

📌 Technologies Used

Spring Boot (REST API development)

Spring Data JPA (Database integration)

Hibernate (ORM framework)

Validation (Jakarta Bean Validation API)

📌 Database Schema & Relationships

1️⃣ Address Entity

Linked to Employee (One-to-One)

2️⃣ Department Entity

Linked to Employees (One-to-Many)

3️⃣ Employee Entity

Linked to Department (Many-to-One)

Linked to Address (One-to-One)

Linked to Projects (Many-to-Many)

4️⃣ Project Entity

Linked to Employees (Many-to-Many)

Linked to Tasks (One-to-Many)

5️⃣ Task Entity

Linked to Project (Many-to-One)
