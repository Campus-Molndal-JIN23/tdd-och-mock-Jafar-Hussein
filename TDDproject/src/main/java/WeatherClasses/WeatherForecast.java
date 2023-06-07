package WeatherClasses;

import java.util.Date;

public class WeatherForecast {
    private double temperature;
    private double windSpeed;
    private String clouds;
    private String city;
    private String country;

    private Date date;

    private String weather;

    public WeatherForecast(double temperature, double windSpeed, String clouds, String city, String country, Date date, String weather) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
        this.city = city;
        this.country = country;
        this.date = date;
        this.weather = weather;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

