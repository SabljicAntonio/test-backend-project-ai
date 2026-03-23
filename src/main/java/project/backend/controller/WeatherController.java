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
                new ForecastDay("Mon", 22, 15, "Sunny",         "sunny"),
                new ForecastDay("Tue", 20, 14, "Partly Cloudy", "partly-cloudy"),
                new ForecastDay("Wed", 11,  7, "Rainy",         "rainy"),
                new ForecastDay("Thu", 13,  9, "Cloudy",        "cloudy"),
                new ForecastDay("Fri", 25, 17, "Sunny",         "sunny")
            )
        );
    }
}
