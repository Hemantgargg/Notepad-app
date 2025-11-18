📘 Notepad App — Spring Boot + Thymeleaf + MySQL

A clean, simple, and modern Notepad Web Application built using Java Spring Boot, Thymeleaf, MySQL, and REST APIs, featuring login, signup, add notes, edit notes, delete notes, and a beautiful UI with toast notifications.

🚀 Features
👤 User Management

Signup

Login

Auto-login persistence using localStorage

Logout

📝 Notes Management

Add new note

Edit existing note

Delete note

View all notes

Notes displayed in modern, Apple-style UI

🎨 UI / UX Features

Premium Apple-like UI

Sticky top navigation bar

Smooth hover animations

Toast success messages (Note added / updated / deleted)

Error messages on login & signup

Fully responsive design

🛠 Tech Stack
Backend

Java 17+

Spring Boot 3+

Spring Web

Spring Data JPA

Spring Security (minimal/customized)

Lombok

Hibernate

MySQL or H2 (dev)

Frontend

Thymeleaf

HTML + CSS

Vanilla JavaScript (Fetch API)

🗂 Folder Structure
notepad-app/
│
├── src/
│   ├── main/
│   │   ├── java/com/ys/notepad/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── NotepadApplication.java
│   │   │
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── login.html
│   │       │   ├── signup.html
│   │       │   ├── notes.html
│   │       │   ├── add-note.html
│   │       │   └── edit-note.html
│   │       └── application.properties
│   │
│   └── test/...
│
├── pom.xml
└── README.md


🧩 Database Schema
User Table
CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);

Notes Table
CREATE TABLE notes (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  content TEXT,
  user_id BIGINT,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

📦 Dummy Data (Optional)
Insert users
INSERT INTO users (email, password)
VALUES 
('test@gmail.com', '$2a$10$H0TgqwJ1D/DWwYcHB3I6AO3zvL8VT6L50N7Kaf42QKwgdM0hlNA9y'), 
('demo@gmail.com', '$2a$10$H0TgqwJ1D/DWwYcHB3I6AO3zvL8VT6L50N7Kaf42QKwgdM0hlNA9y');
-- password = 123456

Insert notes
INSERT INTO notes (title, content, user_id) VALUES
('Shopping List', 'Milk, Eggs, Bread, Butter', 1),
('Project Ideas', 'Build a Spring Boot + React app', 1),
('Workout Plan', 'Monday – Chest\nTuesday – Back', 2);

⚙️ Installation & Setup Guide
✅ 1. Clone the Repository
git clone https://github.com/Hemantgargg/notepad-app.git
cd notepad-app

✅ 2. Configure Database

Open application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/notepad_app
spring.datasource.username=root
spring.datasource.password=*********YOUR_PASSWORD*********

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Create DB manually:

CREATE DATABASE notepad_app;

✅ 3. Build & Run

Using Maven:

mvn spring-boot:run


Or run from STS/IntelliJ.

✅ 4. Open Application
http://localhost:8080/login

🔌 API Endpoints
Auth
Method	URL	Description
POST	/auth/signup	Create new user
POST	/auth/login	Validate credentials
GET	/auth/user-id?email=	Get user ID
Notes
Method	URL	Description
POST	/notes/add	Add new note
GET	/notes/list?userId=	Fetch all notes for user
DELETE	/notes/delete?noteId=ID&userId=ID	Delete a note
GET	/notes/edit/{id}	Load edit page
POST	/notes/update	Update note
🖼 Screenshots 
📌 Login Page  
<img width="1918" height="967" alt="image" src="https://github.com/user-attachments/assets/3114fa58-7b8c-485a-8625-fdd05c45b3f4" />

📌 Signup Page  
<img width="1919" height="973" alt="image" src="https://github.com/user-attachments/assets/bc3fdfa5-84f9-40f6-b116-59c94cdb7b1d" />

📌 Notes Dashboard  
<img width="1913" height="971" alt="image" src="https://github.com/user-attachments/assets/50cb74d0-adc8-4d47-848f-3a1c0e7e973d" />

📌 Add Note  
<img width="1919" height="965" alt="image" src="https://github.com/user-attachments/assets/13f09e81-fedd-4bd5-b976-1cf81ea72241" />

📌 Edit Note  
<img width="1919" height="965" alt="image" src="https://github.com/user-attachments/assets/7eb799d5-87b4-4940-8dc1-c460de22aea5" />


🧑‍💻 Author

Hemant Garg
Spring Boot Developer | Java Enthusiast

🎉 Final Notes

This Notepad app is built to be:

✔ Beginner-friendly
✔ Easy to deploy
✔ Easy to extend
✔ Beautiful & simple to use

Feel free to fork, enhance, and submit PRs!
