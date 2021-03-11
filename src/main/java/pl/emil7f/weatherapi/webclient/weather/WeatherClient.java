package pl.emil7f.weatherapi.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "cbadd1e2fac6a5084c2c34b65afbe179";

    private RestTemplate restTemplate = new RestTemplate();

    public String getWeatherForCity(String city) {
        return restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid={apikey}&units=metric&lang=pl",
                String.class, city, API_KEY);
    }

    public String getForecast(double lat, double lon ) {
        return restTemplate.getForObject(WEATHER_URL + "onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apikey}&units=metric&lang=pl",
                String.class, lat, lon, API_KEY);
    }
}
