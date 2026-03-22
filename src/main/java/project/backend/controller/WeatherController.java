package project.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.backend.model.ForecastDay;
import project.backend.model.WeatherData;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @GetMapping("/weather")
    public WeatherData getWeather() {
        return new WeatherData(
            "San Francisco",
            "US",
            18,
            15,
            "Partly Cloudy",
            72,
            14.5,
            4.2,
            16.0,
            List.of(
                new ForecastDay("Mon", 19, 13, "Sunny",         "sunny"),
                new ForecastDay("Tue", 17, 12, "Partly Cloudy", "partly-cloudy"),
                new ForecastDay("Wed", 14, 10, "Rainy",         "rainy"),
                new ForecastDay("Thu", 16, 11, "Cloudy",        "cloudy"),
                new ForecastDay("Fri", 21, 14, "Sunny",         "sunny")
            )
        );
    }
}
