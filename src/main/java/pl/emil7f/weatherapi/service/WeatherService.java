package pl.emil7f.weatherapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.emil7f.weatherapi.model.WeatherDto;

@Service
public class WeatherService {

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "cbadd1e2fac6a5084c2c34b65afbe179";

    private  RestTemplate restTemplate = new RestTemplate();




    public WeatherDto getWeather() {
        String forObject = getWeatherForCity("porto");
        System.out.println(forObject);
        return null;
    }


    private String getWeatherForCity(String city ) {
        return restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid={apikey}&units=metric&lang=pl",
                String.class, city, API_KEY);
    }
}
