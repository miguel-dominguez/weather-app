package com.weather.weatherapp.service;

import com.weather.weatherapp.dto.WeatherDTO;
import com.weather.weatherapp.model.WeatherData;
import com.weather.weatherapp.util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	
	@Value("${app.api.url}")
	public String appUrl;

	@Value("${app.api.key}")
	public String appKey;
	
	/* 	
	 * This method do a HTTP GET petition to the OpenWeather API
	 * @param String city, is the name of a city i.e. London
	 * @return WeatherInfo object, that contains the weather information of a city
	 * 
	 * */
	public WeatherDTO getWeatherData(String city) throws Exception {							
		RestTemplate restTemplate = new RestTemplate();
        String urlHTTP = appUrl + city + appKey;
        WeatherData weatherData = restTemplate.getForObject(urlHTTP, WeatherData.class);
        WeatherDTO weatherDTO = Util.weatherDataToWeatherDTO(weatherData);
        return weatherDTO;
	}
	
}
