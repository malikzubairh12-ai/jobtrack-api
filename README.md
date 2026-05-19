# JobTrack API Pro

A backend application for tracking job applications. This is a realistic portfolio project for Java Backend / Werkstudent applications.

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Bean Validation
- JUnit 5 / Mockito

## Features

- Add job applications
- Track company, position, location, salary range, status and notes
- Status workflow: SAVED, APPLIED, INTERVIEW, OFFER, REJECTED
- Search applications by company name
- Filter applications by status
- Dashboard statistics
- Clean layered architecture
- Validation and error handling
- API examples for testing with curl or Postman

## Run

```bash
mvn spring-boot:run
```

App URL:

```text
http://localhost:8081
```

H2 console:

```text
http://localhost:8081/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:jobtrackdb
```

## Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/applications` | Get all applications |
| GET | `/api/applications/{id}` | Get one application |
| POST | `/api/applications` | Create application |
| PUT | `/api/applications/{id}` | Update application |
| DELETE | `/api/applications/{id}` | Delete application |
| GET | `/api/applications/search?company=SAP` | Search by company |
| GET | `/api/applications/status/APPLIED` | Filter by status |
| GET | `/api/applications/stats` | Get statistics |

## CV text

**JobTrack API Pro** — Developed a Spring Boot REST API for managing job applications. Implemented CRUD endpoints, database persistence with JPA, validation, search/filter features, statistics endpoint, centralized exception handling and unit tests.
