package WeatherClasses;

import java.util.Date;
import java.util.List;

public class WeatherService {
    final private WeatherApi externalService;
    public WeatherService(WeatherApi externalService) {
        this.externalService = externalService;
    }

    public WeatherForecast getCurrentWeather(String location) {
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Invalid location");
        }
        return externalService.getCurrentForecast(location);
    }

    public List<WeatherForecast> getWeatherForecast(String location, Date date) {
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Invalid location");
        }
        if (date == null) {
            throw new IllegalArgumentException("Invalid date");
        }
        return externalService.getForecast(location, date);
    }

    public WeatherForecast getCordForecast(double lat, double lon) {
        if (lat < -90 || lat > 90 || lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        return externalService.getCordForecast(lat, lon);
    }

    public WeatherForecast searchCityByWeather(String weather) {
        if (weather == null || weather.isEmpty()) {
            throw new IllegalArgumentException("Invalid weather");
        }
        return externalService.searchCityByWeather(weather);
    }

    public void updateWeather(String location) {
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Invalid location");
        }
        externalService.updateWeather(location);
    }

}