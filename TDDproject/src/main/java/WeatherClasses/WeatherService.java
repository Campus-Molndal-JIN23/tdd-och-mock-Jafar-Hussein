package WeatherClasses;

import java.util.Date;
import java.util.List;

public class WeatherService {
    final private WeatherApi externalService;
    public WeatherService(WeatherApi externalService) {
        this.externalService = externalService;
    }

    public WeatherForecast getCurrentWeather(String location) {
        return externalService.getCurrentForecast(location);
    }
    public List<WeatherForecast> getWeatherForecast(String location, Date date) {
        return externalService.getForecast(location, date);
    }
    public void updateWeather(String location) {
        externalService.updateWeather(location);
    }
}