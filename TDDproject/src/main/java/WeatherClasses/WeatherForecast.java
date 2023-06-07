package WeatherClasses;

import java.util.Date;

public class WeatherForecast {
    private double temperature;
    private double windSpeed;
    private int clouds;
    private String city;
    private String country;
    private Date date;

    public WeatherForecast(double temperature, double windSpeed, int clouds, String city, String country, Date date) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
        this.city = city;
        this.country = country;
        this.date = date;
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

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

