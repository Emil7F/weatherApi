package pl.emil7f.weatherapi.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.emil7f.weatherapi.model.WeatherDto;
import pl.emil7f.weatherapi.webclient.dto.OpenWeatherWeatherDto;

@Component
public class WeatherClient {

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "cbadd1e2fac6a5084c2c34b65afbe179";

    private RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherForCity(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto = callGetMethod("weather?q={city}&appid={apikey}&units=metric&lang=pl",
                OpenWeatherWeatherDto.class,
                city, API_KEY);
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setHumidity(openWeatherWeatherDto.getMain().getHumidity());
        weatherDto.setPressure(openWeatherWeatherDto.getMain().getPressure());
        weatherDto.setTemperature(openWeatherWeatherDto.getMain().getTemp());
        weatherDto.setWindSpeed(openWeatherWeatherDto.getWind().getSpeed());
        return weatherDto;
    }

    public WeatherDto getForecast(double lat, double lon) {
        OpenWeatherWeatherDto openWeatherWeatherDto = callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apikey}&units=metric&lang=pl",
                OpenWeatherWeatherDto.class,
                lat, lon, API_KEY);

        WeatherDto weatherDto = new WeatherDto();
// TODO create model to forecast
        return weatherDto;
    }


    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
