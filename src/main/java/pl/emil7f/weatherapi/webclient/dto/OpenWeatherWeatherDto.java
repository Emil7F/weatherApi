package pl.emil7f.weatherapi.webclient.dto;

public class OpenWeatherWeatherDto {
    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;

    public OpenWeatherMainDto getMain() {
        return main;
    }

    public OpenWeatherWindDto getWind() {
        return wind;
    }
}
