# Day 20: Spring Security and API Docs

A small Spring Boot REST API showing Basic Authentication, roles, and Swagger UI documentation.

## Run the project

Use Java 21 and Maven:

```text
mvn spring-boot:run
```

Open Swagger UI at `http://localhost:8080/swagger-ui/index.html`.

## Endpoints and roles

| Endpoint | Access |
| --- | --- |
| `GET /api/public/hello` | Anyone |
| `GET /api/user/profile` | USER or ADMIN |
| `GET /api/admin/dashboard` | ADMIN only |

## Demo accounts

| Username | Password | Role |
| --- | --- | --- |
| `student` | `user123` | USER |
| `admin` | `admin123` | ADMIN |

In Swagger UI, choose **Authorize** and enter one of these accounts. The API documentation itself is public so it is easy to open while learning; the user and admin endpoints still require authentication.

## What to notice

- Basic Authentication checks a username and password on each request.
- Spring Security checks the role before allowing access to a protected endpoint.
- A missing or incorrect login gets HTTP 401. A logged-in user without the required role gets HTTP 403.
- BCrypt encodes the demo passwords in memory.
- OpenAPI describes the endpoints and Basic Authentication. Swagger UI lets you view and try them.

These accounts are for local learning only. Basic Authentication must be used over HTTPS outside a local demo, and real applications should keep credentials in secure configuration rather than source code.
