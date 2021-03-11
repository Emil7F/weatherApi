package pl.emil7f.weatherapi.webclient.dto;

public class OpenWeatherMainDto {
    private float temp;
    private int pressure;
    private int humidity;

    public float getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
