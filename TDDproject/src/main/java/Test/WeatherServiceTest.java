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
        // Arrange
        // Create a mock WeatherForecast object
        WeatherForecast mockForecast = Mockito.mock(WeatherForecast.class);

        // Define the location for the forecast
        String location = "Gothenburg";

        // Mock the behavior of the weatherApi
        when(weatherApi.getCurrentForecast(location)).thenReturn(mockForecast);

        // Act
        // Call the method under test
        WeatherForecast actualForecast = sut.getCurrentWeather(location);

        // Assert
        // Verify the expected result
        assertEquals(mockForecast, actualForecast);
    }

    @Test
    public void testGetWeatherForecast() {
        // Arrange
        // Create a mock WeatherForecast object
        WeatherForecast mockForecast = mock(WeatherForecast.class);
        when(mockForecast.getTemperature()).thenReturn(25.5);
        when(mockForecast.getWindSpeed()).thenReturn(12.3);
        when(mockForecast.getClouds()).thenReturn("Sunny");
        when(mockForecast.getCity()).thenReturn("Stockholm");
        when(mockForecast.getCountry()).thenReturn("Sweden");
        when(mockForecast.getDate()).thenReturn(new Date());

        // Define the expected forecast list
        List<WeatherForecast> expectedForecastList = new ArrayList<>();
        expectedForecastList.add(mockForecast);

        // Define the location and date for the forecast
        String location = "Stockholm";
        Date date = new Date();

        // Mock the behavior of the weatherApi
        when(weatherApi.getForecast(location, date)).thenReturn(expectedForecastList);

        // Act
        // Call the method under test
        List<WeatherForecast> actualForecastList = sut.getWeatherForecast(location, date);

        // Assert
        // Verify the expected result
        assertEquals(expectedForecastList, actualForecastList);
    }

    @Test
    public void testGetCordForecast() {
        // Arrange
        double lat = 52.520008; // Example latitude value
        double lon = 13.404954; // Example longitude value

        WeatherForecast mockForecast = mock(WeatherForecast.class);
        when(weatherApi.getCordForecast(lat, lon)).thenReturn(mockForecast);

        // Act
        WeatherForecast actualForecast = sut.getCordForecast(lat, lon);

        // Assert
        assertEquals(mockForecast, actualForecast);
        verify(weatherApi).getCordForecast(lat, lon);
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
        // Arrange
        String value = "Stockholm";

        // Act
        // Call the method under test
        sut.updateWeather(value);

        // Assert
        // Verify that the weatherApi.updateWeather() method was called with the correct location
        Mockito.verify(weatherApi).updateWeather(value);
    }
    @Test
    public void testGetCurrentWeather_InvalidLocation() {
        // Arrange
        String invalidLocation = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> sut.getCurrentWeather(invalidLocation));
    }

    @Test
    public void testGetWeatherForecast_InvalidLocation() {
        // Arrange
        String invalidLocation = "";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> sut.getWeatherForecast(invalidLocation, new Date()));
    }

    @Test
    public void testGetWeatherForecast_InvalidDate() {
        // Arrange
        String location = "Stockholm";
        Date invalidDate = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> sut.getWeatherForecast(location, invalidDate));
    }

    @Test
    public void testGetCordForecast_InvalidCoordinates() {
        // Arrange
        double invalidLat = 100.0;
        double invalidLon = -200.0;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> sut.getCordForecast(invalidLat, invalidLon));
    }

    @Test
    public void testSearchCityByWeather_InvalidWeather() {
        // Arrange
        String invalidWeather = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> sut.searchCityByWeather(invalidWeather));
    }

    @Test
    public void testUpdateWeather_InvalidLocation() {
        // Arrange
        String invalidLocation = "";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> sut.updateWeather(invalidLocation));
    }


}
