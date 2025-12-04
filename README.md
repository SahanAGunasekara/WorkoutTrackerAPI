# 🏋️ Workout Tracker API

Workout Tracker API is a Spring Boot–based backend service designed to help users manage their workout plans efficiently. It enables users to create accounts, log in, and handle workout-related activities such as adding exercises, updating progress, scheduling sessions, and more.

---

## 🚀 Features

- **User Authentication**
  - Sign-Up — Create a new account
  - Login — Authenticate users and allow access to workouts

- **Workout Management**
  - Create a Workout with multiple exercises
  - Update Workout details and comments
  - Delete a Workout
  - List all workouts sorted by date and time
  - Schedule workouts for specific dates and times

---

## 🛠️ Tech Stack

| Technology | Usage |
|-----------|------|
| Spring Boot | Backend Framework |
| Spring Data JPA | Database Operations |
| MySQL | Database |
| Spring Security | Authentication & Authorization |
| Maven | Build + Dependency Management |
| Java 17+ | Programming Language |

---

## 📌 API Endpoints

### 🔐 Authentication
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/signUp/registerUser` | Create a new user account |
| POST | `/api/v1/signUp/SignInUser` | Login and receive auth token |

---

### 🏋️ Workout Operations
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/Workout/createWorkout` | Create a new workout |
| PUT | `/api/v1/workout/updateWorkout/` | Update workout details |
| DELETE | `/api/v1/workout/deleteWorkout/{title}` | Delete a workout by title |
| GET | `/api/v1/workout/userWorkoutList` | List all workouts sorted by date & time |

---

### 🗓️ Workout Scheduling
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/scheduleWorkout/createScheduleWorkout` | Schedule workout for a date & time |



---

## 📦 Project Setup

### Clone Repository
```bash
https://github.com/SahanAGunasekara/WorkoutTrackerAPI.git
cd workout-tracker-api
