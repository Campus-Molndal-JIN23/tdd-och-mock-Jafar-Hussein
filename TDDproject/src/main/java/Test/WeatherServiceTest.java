package Test;

import WeatherClasses.ExternalWeatherService;
import WeatherClasses.WeatherForecast;
import WeatherClasses.WeatherService;

import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {
    @Mock
    private ExternalWeatherService externalService;

    private WeatherService weatherService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        weatherService = new WeatherService(externalService);
    }

    @Test //metod för att testa om en stad finns genom att söka efter koordinater
    public void testGetWeatherForecast_ValidCoordinates_ReturnsValidForecast() {
        // Prepare mock JSON response string
        String mockJsonResponse = "{ \"coord\": { \"lon\": 11.97, \"lat\": 57.71 }, \"weather\": [ { \"id\": 804, \"main\": \"Clouds\", \"description\": \"overcast clouds\", \"icon\": \"04d\" } ], \"base\": \"stations\", \"main\": { \"temp\": 20.59, \"feels_like\": 20.13, \"temp_min\": 18.89, \"temp_max\": 21.74, \"pressure\": 1013, \"humidity\": 67 }, \"visibility\": 10000, \"wind\": { \"speed\": 5.14, \"deg\": 210, \"gust\": 7.2 }, \"clouds\": { \"all\": 90 }, \"dt\": 1599478913, \"sys\": { \"type\": 1, \"id\": 1752, \"country\": \"SE\", \"sunrise\": 1599457990, \"sunset\": 1599510755 }, \"timezone\": 7200, \"id\": 2711537, \"name\": \"Gothenburg\", \"cod\": 200 }";

        // Deserialize the mock JSON response into a WeatherForecast object using Gson
        Gson gson = new Gson();
        WeatherForecast expectedForecast = gson.fromJson(mockJsonResponse, WeatherForecast.class);

        // Configure the mock to return the expected forecast
        when(externalService.getCordForecast(11.97, 57.71)).thenReturn(expectedForecast);

        // Invoke the WeatherService method
        WeatherForecast actualForecast = weatherService.getCordForecast(11.97, 57.71);

        // Validate the result
        assertEquals(expectedForecast, actualForecast);

        // Verify that the external service was called with the correct parameters
        verify(externalService, times(1)).getCordForecast(11.97, 57.71);
    }

    // ... other test methods ...
}