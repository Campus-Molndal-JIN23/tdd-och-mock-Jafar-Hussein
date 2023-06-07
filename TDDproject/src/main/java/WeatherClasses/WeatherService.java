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

    // Convert WeatherForecast to JSON string
    private String toJSON(WeatherForecast forecast) {
        String json = "{";
        json += "\"temperature\":" + forecast.getTemperature() + ",";
        json += "\"windSpeed\":" + forecast.getWindSpeed() + ",";
        json += "\"clouds\":\"" + forecast.getClouds() + "\",";
        json += "\"city\":\"" + forecast.getCity() + "\",";
        json += "\"country\":\"" + forecast.getCountry() + "\",";
        json += "\"date\":\"" + forecast.getDate() + "\",";
        json += "\"weather\":\"" + forecast.getWeather() + "\",";
        json += "\"lat\":" + forecast.getLat() + ",";
        json += "\"lon\":" + forecast.getLon();
        json += "}";
        return json;
    }

    // Convert WeatherForecast list to JSON string
    private String toJSON(List<WeatherForecast> forecastList) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (WeatherForecast forecast : forecastList) {
            jsonBuilder.append(toJSON(forecast)).append(",");
        }
        if (forecastList.size() > 0) {
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1); // Remove the last comma
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    // Additional methods for converting WeatherForecast to JSON
    private String getCurrentWeatherJSON(String location) {
        WeatherForecast forecast = getCurrentWeather(location);
        return toJSON(forecast);
    }

    private String getWeatherForecastJSON(String location, Date date) {
        List<WeatherForecast> forecastList = getWeatherForecast(location, date);
        return toJSON(forecastList);
    }

    private String getCordForecastJSON(double lat, double lon) {
        WeatherForecast forecast = getCordForecast(lat, lon);
        return toJSON(forecast);
    }

    private String searchCityByWeatherJSON(String weather) {
        WeatherForecast forecast = searchCityByWeather(weather);
        return toJSON(forecast);
    }
}
