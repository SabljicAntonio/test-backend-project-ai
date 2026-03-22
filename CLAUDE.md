# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Run the application
./gradlew bootRun

# Build
./gradlew build

# Run tests
./gradlew test

# Run a single test class
./gradlew test --tests "project.backend.BackendApplicationTests"

# Clean build artifacts
./gradlew clean
```

On Windows, use `gradlew.bat` instead of `./gradlew`.

## Architecture

This is a Spring Boot 4.x web application (Java 17) built with Gradle.

- **Entry point:** `src/main/java/project/backend/BackendApplication.java`
- **Config:** `src/main/resources/application.yaml`
- **Package root:** `project.backend`

Dependencies in use: Spring Web MVC, Lombok, Spring DevTools, Spring Configuration Processor.

Static assets go in `src/main/resources/static/`, server-side templates in `src/main/resources/templates/`.
