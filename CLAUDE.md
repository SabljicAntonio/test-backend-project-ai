# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Run the application
./mvnw spring-boot:run

# Build
./mvnw package

# Run tests
./mvnw test

# Run a single test class
./mvnw test -Dtest="BackendApplicationTests"

# Clean build artifacts
./mvnw clean
```

On Windows, use `mvnw.cmd` instead of `./mvnw`.

## Architecture

This is the backend of a **monolithic weather application**. It is a Spring Boot 4.x web application (Java 17) built with Maven.

- **Entry point:** `src/main/java/project/backend/BackendApplication.java`
- **Config:** `src/main/resources/application.yaml` (serves on port 8080)
- **Package root:** `project.backend`
- **API:** `controller/WeatherController` — `GET /api/weather` returns hardcoded `WeatherData` (city, temperature, humidity, wind, UV index, visibility, 5-day forecast)
- **Models:** `model/WeatherData` and `model/ForecastDay` — plain Java records, serialized to JSON by Jackson

Dependencies in use: Spring Web MVC, Lombok, Spring DevTools, Spring Configuration Processor.

The Maven build includes an `exec-maven-plugin` execution (`npm run build` in `../frontend`) and a `maven-resources-plugin` execution that copies `dist/` into `src/main/resources/static/`, producing a single self-contained JAR.
