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

### 🔹 Database

-   MySQL
-   Hibernate ORM
-   JPA (Java Persistence API)

### 🔹 Frontend

-   ReactJS
-   Axios (for API communication)

------------------------------------------------------------------------

## 🧠 Key Features

### ✅ User Features

-   Add, update, delete expenses
-   Add, update, delete investments
-   Categorize transactions
-   View complete transaction history
-   Real-time data updates via API integration
-   Clean and responsive React UI

### ✅ System Features

-   Layered architecture (Controller → Service → Repository)
-   RESTful API design
-   ORM-based database interaction (Hibernate)
-   Axios-based frontend-backend communication
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

-   Java 17+
-   Maven
-   MySQL

### 2️⃣ Configure Database

Update `application.properties`:

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
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

  Method   Endpoint             Description
  -------- -------------------- -----------------------
  GET      /api/expenses        Fetch all expenses
  POST     /api/expenses        Add new expense
  PUT      /api/expenses/{id}   Update expense
  DELETE   /api/expenses/{id}   Delete expense
  GET      /api/investments     Fetch all investments
  POST     /api/investments     Add investment

------------------------------------------------------------------------

## 🧪 Testing APIs

Use: - Postman - cURL - Browser DevTools (Network tab)

Example:

``` bash
curl http://localhost:8080/api/expenses
```

------------------------------------------------------------------------

## 📈 Why This Project Stands Out

✔ Demonstrates full-stack development skills\
✔ Clean backend architecture using Spring Boot\
✔ Modern React frontend\
✔ Proper database design with JPA & Hibernate\
✔ Real-world financial use case\
✔ Production-ready structure

This project highlights strong backend fundamentals, frontend
integration skills, and database handling --- ideal for showcasing
full-stack capabilities in interviews and portfolios.

------------------------------------------------------------------------

## 🤝 Contribution

Contributions are welcome!

1.  Fork the repository\
2.  Create your feature branch\
3.  Commit your changes\
4.  Push and open a Pull Request

------------------------------------------------------------------------

## 📜 License

This project is open-source and available for educational and
professional portfolio use.

------------------------------------------------------------------------

## 👨‍💻 Author

Built with dedication by a Java Full-Stack Developer passionate about
scalable and clean architecture.
