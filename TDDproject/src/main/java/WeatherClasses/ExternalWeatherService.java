package WeatherClasses;

public interface ExternalWeatherService {
    WeatherForecast getForecast(String city);
    WeatherForecast getCordForecast(double lat, double lon);
}
