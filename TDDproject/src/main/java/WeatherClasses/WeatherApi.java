package WeatherClasses;

import java.util.Date;
import java.util.List;

public interface WeatherApi {
    WeatherForecast getCurrentForecast(String location);
    List<WeatherForecast> getForecast(String location, Date date);
    WeatherForecast searchCityByWeather(String weather);

    void updateWeather(String location);
}