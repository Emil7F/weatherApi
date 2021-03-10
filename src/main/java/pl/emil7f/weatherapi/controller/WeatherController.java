package pl.emil7f.weatherapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.emil7f.weatherapi.model.WeatherDto;
import pl.emil7f.weatherapi.service.WeatherService;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherDto getWeather() {
       return weatherService.getWeather();
    }
}
