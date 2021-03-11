package pl.emil7f.weatherapi.service;

import org.springframework.stereotype.Service;
import pl.emil7f.weatherapi.model.WeatherDto;
import pl.emil7f.weatherapi.webclient.weather.WeatherClient;

@Service
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherDto getWeather() {
        String forObject = weatherClient.getWeatherForCity("porto");
        System.out.println(forObject);

        String forecast = weatherClient.getForecast(32.7, -16.98);
        System.out.println(forecast);
        return null;
    }


}
