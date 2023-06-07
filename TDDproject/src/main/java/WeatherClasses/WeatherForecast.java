package WeatherClasses;

import java.util.Date;

public class WeatherForecast {
    private final double temperature;
    private final double windSpeed;
    private final String clouds;
    private final String city;
    private final String country;

    private final Date date;

    private final String weather;
    private double lat;
    private double lon;

    public WeatherForecast(double temperature, double windSpeed, String clouds, String city, String country, Date date, String weather, double lat, double lon) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
        this.city = city;
        this.country = country;
        this.date = date;
        this.weather = weather;
        this.lat = lat;
        this.lon = lon;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLon() {
        return lon;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getWindSpeed() {
        return windSpeed;
    }


    public String getClouds() {
        return clouds;
    }


    public String getCity() {
        return city;
    }


    public String getCountry() {
        return country;
    }


    public String getWeather() {
        return weather;
    }
    public Date getDate() {
        return date;
    }

    public String toJSON() {
        String json = "{";
        json += "\"temperature\":" + temperature + ",";
        json += "\"windSpeed\":" + windSpeed + ",";
        json += "\"clouds\":\"" + clouds + "\",";
        json += "\"city\":\"" + city + "\",";
        json += "\"country\":\"" + country + "\",";
        json += "\"date\":\"" + date + "\",";
        json += "\"weather\":\"" + weather + "\",";
        json += "\"lat\":" + lat + ",";
        json += "\"lon\":" + lon;
        json += "}";
        return json;
    }
    }


