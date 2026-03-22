package project.backend.model;

public record ForecastDay(
    String day,
    int high,
    int low,
    String condition,
    String icon
) {}
