# WeatherService - Testrapport

## WeatherService
### paketer
+ #### Junit 5:
Jag använde mig av senaste versionen av Junit 5 för att kunna skapa dessa unit tester till mitt program
+ ### Mockito
Jag använde mig även av senaste versionen mockito för att kunna simulera en api för att kunna testa mina metoder.
+ ### Json
Jag använde mig av json för att kunna läsa in en json fil.

### TDD
Test-Driven Development (TDD) är en metodik där testerna skrivs före koden. Genom att först definiera testfallen och sedan implementera koden för att passera testen säkerställer TDD att koden uppfyller sina krav och fungerar som förväntat. Fördelarna med att använda TDD inkluderar:
+ #### Bättre kodkvalitet
+ #### Bättre testtäckning

### Mock
Mock-objekt används i testning för att isolera den delen av koden som testas från beroenden till andra delar av systemet. Genom att skapa och använda mock-objekt kan testerna fokusera på att testa en specifik enhet eller komponent utan att påverkas av de verkliga implementationerna av dess beroenden. Fördelarna med att använda mock-objekt inkluderar
+ #### Bättre testisolering
+ #### Bättre testprestanda
+ #### ökad flexibilitet
+ 
### Information
 + WeatherService-klassen är en central komponent i WeatherClasses-paketet och fungerar som ett gränssnitt mellan applikationen och WeatherApi (väder-API). Klassen tillhandahåller olika metoder för att hämta väderprognoser och information från det externa API:et.
 + Här är en översikt över de viktigaste metoderna i WeatherService-klassen:
### konstruktor
+ WeatherService(WeatherApi externalService): Skapar en ny instans av WeatherService med en extern tjänst som parameter. Den externa tjänsten implementerar WeatherApi-gränssnittet och används för att hämta väderdata.

### Metoder som testas
+ #### getCurrentWeather(String location):
+ Returnerar den aktuella väderprognosen för en given plats. Om platsen är ogiltig (null eller tom sträng) kastas ett undantag.
+ #### getWeatherForecast(String location, Date date):
+ Returnerar väderprognosen för en given plats och ett givet datum. Om platsen är ogiltig (null eller tom sträng) kastas ett undantag. Om datumet är ogiltigt (null) kastas ett undantag.
+ #### getCordForecast(double latitude, double longitude):
+ Returnerar väderprognosen för en given plats och ett givet datum. Om latitud- eller longitudvärdena är ogiltiga (null) kastas ett undantag.
+ #### searchCityByWeather(String weather): 
+ Returnerar en lista med städer som har ett givet väder. Om väder är ogiltigt (null eller tom sträng) kastas ett undantag.
+ #### updateWeather(String location): 
+ Uppdaterar väderprognosen för en given plats. Om platsen är ogiltig (null eller tom sträng) kastas ett undantag.

WeatherService-klassen är utformad för att vara flexibel och enkel att använda. Den tar emot en implementation av WeatherApi-gränssnittet via konstruktorn, vilket gör det möjligt att byta ut eller mocka API-implementeringen vid behov.

### Tester som har utförts
+ #### Test av getCurrentWeather(String location)
Ett test genomfördes för att kontrollera om metoden returnerar rätt väderinformation för en given plats. Detta inkluderade att mocka WeatherApi och verifiera att det returnerade WeatherForecast-objektet innehöll korrekta värden för temperatur, vindhastighet, molnighet, stad och land.
+ #### Test av getWeatherForecast(String location, Date date)
Ett test utfördes fEtt test utfördes för att säkerställa att metoden returnerar en korrekt väderprognos för en given plats och datum. Detta innebar att mocka WeatherApi och kontrollera att den returnerade listan av WeatherForecast-objekt innehöll förväntade värden baserat på de angivna parametrarna.

+ #### Test av getCordForecast(double latitude, double longitude)
Ett test genomfördes för att verifiera att metoden returnerar rätt väderprognos baserat på de angivna geografiska koordinaterna. Mockning av WeatherApi användes för att säkerställa att det returnerade WeatherForecast-objektet innehöll korrekta värden för väder, temperatur, vindhastighet, molnighet, stad och land.
+ #### Test av searchCityByWeather(String weather)
Ett test utfördes för att kontrollera om metoden returnerar en korrekt väderprognos för en stad som matchar den angivna väderbeskrivningen. Mockning av WeatherApi användes för att säkerställa att det returnerade WeatherForecast-objektet innehöll korrekta värden för väder, temperatur, vindhastighet, molnighet, stad och land.
+ #### Test av updateWeather(String location)
Ett test genomfördes för att verifiera att metoden uppdaterar vädret för en given plats genom att anropa det externa API:et. Detta test inkluderade att kontrollera om WeatherApi-metoden för att uppdatera vädret anropades korrekt.

### Pålitlighet och problem:
Baserat på min testning och genomgång av koden, verkar WeatherService-klassen vara tillförlitlig och fungera enligt förväntningarna. Den hanterar ogiltiga indata genom att kasta IllegalArgumentException och förlitar sig på WeatherApi-implementeringen för att hämta korrekt väderinformation.

Under testningen upptäckte jag inga problem eller fel i själva WeatherService-klassen. Alla metoderna fungerade som förväntat och returnerade korrekta värden. Dock är det viktigt att notera att tillförlitligheten i själva WeatherApi-implementeringen är avgörande för att få korrekta väderdata, så eventuella problem eller fel i den implementationen kan påverka funktionen hos WeatherService-klassen.