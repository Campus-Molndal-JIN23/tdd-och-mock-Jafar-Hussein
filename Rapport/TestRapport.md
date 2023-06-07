# TestRapport

| Test                                   | Beskrivning                                                                                       | Resultat        |
|----------------------------------------|---------------------------------------------------------------------------------------------------|-----------------|
| testGetCurrentWeather                  | Testar metoden getCurrentWeather för att hämta nuvarande väder                                    | Godkänt|
| testGetWeatherForecast                 | Testar metoden getWeatherForecast för att hämta   vädder från en specifik datum                   | Godkänt |
| testGetCordForecast                    | Testar metoden getCordForecast för att hämta en stad genom koordinater                            | Godkänt |
| testSearchCityByWeather                | Testar metoden searchCityByWeather för att hämta information av en stad genom namn                | Godkänt |
| testUpdateWeather                      | Testar metoden testUpdateWeather för att uppdatera information                                    | Godkänt |
| testGetCurrentWeather_InvalidLocation  | Testar getCurrentWeather med ogiltig plats (null). | Godkänt |
| testGetWeatherForecast_InvalidLocation | Testar getWeatherForecast med ogiltig plats (tom sträng).                            | Godkänt |
| testGetWeatherForecast_InvalidDate   | Testar getWeatherForecast med ogiltigt datum (null).                           | Godkänt |
| testGetCordForecast_InvalidCoordinates| Testar getCordForecast med ogiltiga latitud- och longitudvärden.                       | Godkänt |
| testSearchCityByWeather_InvalidWeather	   | Testar searchCityByWeather med ogiltigt väder (null).                         | Godkänt |
| testGetCurrentWeather_InvalidApiKey    | Testar updateWeather med ogiltig plats (tom sträng).                     | Godkänt |
