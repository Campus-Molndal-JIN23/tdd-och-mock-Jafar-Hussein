package WeatherClasses;

import java.util.Date;
import java.util.List;

public interface WeatherApi {
    WeatherForecast getCurrentForecast(String location);
    List<WeatherForecast> getForecast(String location, Date date);

    void updateWeather(String location);
}