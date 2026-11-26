# Day 21: Capstone Polish

A small secured task API showing a clear README, helpful error responses, tests, and optional Docker support.

## What the project includes

- Basic Authentication with USER and ADMIN roles.
- A tiny in-memory task list.
- A readable JSON response when a task does not exist.
- Swagger UI documentation for the endpoints.
- Unit and API security tests.
- An optional Dockerfile.

## Run locally

Use Java 21 and Maven:

```text
mvn spring-boot:run
```

Open Swagger UI at `http://localhost:8080/swagger-ui/index.html`. The OpenAPI JSON is at `http://localhost:8080/v3/api-docs`.

## Endpoints

| Endpoint | Access | Result |
| --- | --- | --- |
| `GET /api/public/hello` | Anyone | Public welcome message |
| `GET /api/user/profile` | USER or ADMIN | User area message |
| `GET /api/admin/dashboard` | ADMIN only | Admin area message |
| `GET /api/user/tasks` | USER or ADMIN | List the sample tasks |
| `GET /api/user/tasks/{id}` | USER or ADMIN | Find one task |

## Demo accounts

| Username | Password | Role |
| --- | --- | --- |
| `student` | `user123` | USER |
| `admin` | `admin123` | ADMIN |

In Swagger UI, select **Authorize** and enter one account. These accounts are for local learning only. Basic Authentication should be used over HTTPS outside a local demo, and real applications should keep credentials in secure configuration rather than source code.

## Error handling

If a task ID is not in the sample list, the API returns HTTP 404 and a small JSON response such as:

```json
{
  "status": 404,
  "message": "Task 99 was not found."
}
```

`TaskNotFoundException` describes the problem. `GlobalExceptionHandler` turns it into a consistent HTTP response.

## Run the tests

```text
mvn test
```

The tests check task lookup, the not-found response, login requirements, and USER versus ADMIN access.

## Optional: run with Docker

Build and start the container from this folder:

```text
docker build -t day21-capstone .
docker run --rm -p 8080:8080 day21-capstone
```

Then open the same Swagger UI address. Docker is optional; the project also runs directly with Maven.
