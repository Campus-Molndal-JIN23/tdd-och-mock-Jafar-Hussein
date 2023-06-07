package Test;

import java.util.Date;
import WeatherClasses.WeatherApi;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import WeatherClasses.WeatherForecast;
import WeatherClasses.WeatherService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {
    @Mock
    private WeatherApi weatherApi;
    private WeatherService sut;

    @BeforeEach
    public void setup() {
        // Skapa en mock WeatherApi
        weatherApi = Mockito.mock(WeatherApi.class);

        // Skapa en WeatherService-instans med mock WeatherApi
        sut = new WeatherService(weatherApi);
    }

    @Test
    public void testGetCurrentWeather() {
        // Skapa en mock WeatherForecast-objekt
        WeatherForecast mockForecast = Mockito.mock(WeatherForecast.class);

        // Definiera platsen för prognosen
        String location = "Gothenburg";

        // Mocka beteendet för den externa tjänsten
        when(weatherApi.getCurrentForecast(location)).thenReturn(mockForecast);

        // Anropa metoden som ska testas
        WeatherForecast actualForecast = sut.getCurrentWeather(location);

        // Verifiera resultatet
        assertEquals(mockForecast, actualForecast);
    }
    @Test
    public void testGetWeatherForecast() {
        // Skapa en mock WeatherForecast-objekt
        WeatherForecast mockForecast = mock(WeatherForecast.class);

        // Definiera beteendet för mock objektet
        when(mockForecast.getTemperature()).thenReturn(25.5);
        when(mockForecast.getWindSpeed()).thenReturn(12.3);
        when(mockForecast.getClouds()).thenReturn("Sunny");
        when(mockForecast.getCity()).thenReturn("Stockholm");
        when(mockForecast.getCountry()).thenReturn("Sweden");
        when(mockForecast.getDate()).thenReturn(new Date());

        // Mocka den förväntade prognoslistan
        List<WeatherForecast> expectedForecastList = new ArrayList<>();
        expectedForecastList.add(mockForecast);

         // Definiera platsen och datumet för prognosen
        String location = "Stockholm";
        Date date = new Date();

        // Mocka beteendet för den externa tjänsten
        when(weatherApi.getForecast(location, date)).thenReturn(expectedForecastList);

        // Anropa metoden som ska testas
        List<WeatherForecast> actualForecastList = sut.getWeatherForecast(location, date);

        // Verifiera resultatet
        assertEquals(expectedForecastList, actualForecastList);
    }

    @Test
    public void testSearchCityByWeather(){
        //arrange
        WeatherForecast mockForecast = mock(WeatherForecast.class);
        String value = "Sunny";
        when(weatherApi.searchCityByWeather(value)).thenReturn(mockForecast);
        //act
        WeatherForecast actualForecast = sut.searchCityByWeather("Sunny");

        //assert
        assertEquals(mockForecast, actualForecast);
    }

    @Test
    public void testUpdateWeather() {
        // Anropa metoden som ska testas
        sut.updateWeather("location");

        // Verifiera att WeatherApi.updateWeather() metoden blev anropad
        Mockito.verify(weatherApi).updateWeather("location");
    }


}
