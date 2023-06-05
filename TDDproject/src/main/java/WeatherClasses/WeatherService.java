package WeatherClasses;

public class WeatherService {
    private WeatherClasses.ExternalWeatherService externalService;
    public WeatherService(WeatherClasses.ExternalWeatherService externalService) {
        this.externalService = externalService;
    }

    public WeatherForecast getWeatherForecast(String city) {
        // Anropa den externa tjänsten för att hämta väderprognosen för den angivna staden
        return externalService.getForecast(city);
    }
    public WeatherForecast getCordForecast(double lat, double lon) {
        // Anropa den externa tjänsten för att hämta väderprognosen för den angivna staden
        return externalService.getCordForecast(lat, lon);
    }
}