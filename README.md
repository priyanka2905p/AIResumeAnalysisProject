# AI Resume Analysis

## 📌 Overview
AI Resume Analysis is a Spring Boot application that analyzes resumes and provides insights such as skill extraction, keyword matching, and resume scoring.  
It helps job seekers improve their resumes and assists recruiters in screening candidates efficiently.

---

## 🚀 Features
- Upload Resume (PDF/DOC)
- Extract Resume Text
- Analyze Skills & Keywords
- Match Resume with Job Description
- Generate Resume Score
- REST API Support

---

## 🛠️ Technologies Used
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- H2 Database (In-Memory)

---

## 📂 Project Structure
```
airesumeanalysis/
│
├── src/main/java/
├── src/main/resources/
├── pom.xml
└── README.md
```

---

## ⚙️ How to Run

### 1. Clone the Repository
```
git clone https://github.com/your-username/airesumeanalysis.git
```

### 2. Go to Project Folder
```
cd airesumeanalysis
```

### 3. Run the Application
```
mvn spring-boot:run
```

The application will start at:
```
http://localhost:8080
```

---

## 🔗 Sample API Endpoints

| Method | Endpoint        | Description        |
|--------|----------------|--------------------|
| POST   | /upload        | Upload Resume      |
| POST   | /analyze       | Analyze Resume     |
| GET    | /score/{id}    | Get Resume Score   |

---

## 🎯 Future Improvements
- Machine Learning based scoring
- Job recommendation system
- Authentication & Authorization
- Cloud deployment

---

## 👩‍💻 Author
Priyanka Pawar  
Java Full Stack Developer  

---

## 📜 License
This project is created for educational purposes.