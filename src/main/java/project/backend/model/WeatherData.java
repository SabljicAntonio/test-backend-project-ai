package project.backend.model;

import java.util.List;

public record WeatherData(
    String city,
    String country,
    int temperature,
    int feelsLike,
    String condition,
    int humidity,
    double windSpeed,
    double uvIndex,
    double visibility,
    List<ForecastDay> forecast
) {}
