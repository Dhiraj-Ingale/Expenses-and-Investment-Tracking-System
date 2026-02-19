# 📊 Expenses & Investment Tracking System

A modern full-stack financial management web application built using
**Java Spring Boot** and **ReactJS**.\
This system helps users efficiently track expenses, manage investments,
and monitor overall financial health through an intuitive interface and
robust backend architecture.

------------------------------------------------------------------------

## 🚀 Project Overview

The **Expenses & Investment Tracking System** is designed to simplify
personal financial management.\
It enables users to:

-   💰 Track daily expenses
-   📈 Record and manage investments
-   📊 Monitor financial summaries
-   🗂 Categorize transactions
-   🔍 View and filter financial records

This project demonstrates real-world full-stack development practices
using RESTful APIs, modern frontend frameworks, and relational database
integration.

------------------------------------------------------------------------

## 🛠️ Tech Stack

### 🔹 Backend

-   Java
-   Spring Boot
-   Spring Data JPA
-   Hibernate
-   RESTful APIs
-   Maven

### 🔹 Database

-   MySQL
-   Hibernate ORM
-   JPA (Java Persistence API)

### 🔹 Frontend

-   ReactJS
-   Axios (HTTP client for API communication)

----------------------------------------------------------------------

## 🏗️ Architecture Overview

The application follows industry-standard layered architecture:

    Client (ReactJS)
          ↓ Axios (REST Calls)
    Spring Boot Controller Layer
          ↓
    Service Layer (Business Logic)
          ↓
    Repository Layer (JPA/Hibernate)
          ↓
    MySQL Database

This ensures:

-   Separation of concerns
-   Maintainability
-   Scalability
-   Clean code practices

------------------------------------------------------------------------

## 🧠 Key Features

### ✅ User Features

-   Add, update, delete expenses
-   Add, update, delete incomes
-   Add, update, delete investments
-   Categorize transactions
-   View complete transaction history
-   Real-time data updates via API integration
-   Clean and responsive React UI

### ✅ System Features

-   Annotation-driven configuration
-   RESTful API design
-   ORM-based database interaction (Hibernate)
-   Axios-based frontend-backend asynchronous communication
-   Clean separation of concerns
-   Scalable and maintainable project structure

------------------------------------------------------------------------

## 📁 Project Structure

    Expenses-and-Investment-Tracking-System
    │
    ├── backend/
    │   ├── controller/
    │   ├── service/
    │   ├── repository/
    │   ├── model/
    │   └── application.properties
    │
    ├── frontend/
    │   ├── src/
    │   │   ├── components/
    │   │   ├── services/
    │   │   └── App.js
    │   └── package.json
    │
    └── pom.xml

------------------------------------------------------------------------

## ⚙️ Backend Setup (Spring Boot)

### 1️⃣ Prerequisites

-   Java 11+
-   Maven
-   MySQL

### 2️⃣ Configure Database

Update `application.properties`:

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/expensetracker
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Run Backend

``` bash
mvn clean install
mvn spring-boot:run
```

Backend runs at:

    http://localhost:8080

------------------------------------------------------------------------

## 💻 Frontend Setup (ReactJS)

### 1️⃣ Navigate to frontend

``` bash
cd frontend
```

### 2️⃣ Install Dependencies

``` bash
npm install
```

### 3️⃣ Start React App

``` bash
npm start
```

Frontend runs at:

    http://localhost:3000

Axios handles API communication between React and Spring Boot.

------------------------------------------------------------------------

## 📌 API Architecture

The application follows RESTful principles:

  Method   Endpoint                 Description
  -------- --------------------     -----------------------
  GET      /expenses/all            Fetch all expenses
  POST     /expenses                Add new expense
  PUT      /expenses/{expenseId}    Update expense
  DELETE   /expenses/{expenseId}    Delete expense
  GET      /investments             Fetch all investments
  POST     /investments             Add investment

------------------------------------------------------------------------

## 🧪 Testing APIs

Use: - Postman - cURL - Browser DevTools (Network tab)

Example:

``` bash
curl http://localhost:8080/expenses
```

------------------------------------------------------------------------

## 🔮 Future Enhancements

-   JWT-based authentication & authorization
-   Role-based access control
-   Dashboard analytics & charts
-   Dockerized deployment
-   CI/CD pipeline integration

