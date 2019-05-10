## weather-app

Application that show weather information of an specific city.

### Requirements

For building and running the application you need:

- JDK 1.8
- Maven 3

### Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the `com.weather.weatherapp.WeatherApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) following the next steps:

1. Open a terminal
2. Change the current directory to the project folder
3. Launch the server running the command

```
mvn spring-boot:run
```
4. Open a Web browser and type the URL 

```
http://localhost:8080/
```
5. Select a city and press the "Search" button to see the weather information about the city