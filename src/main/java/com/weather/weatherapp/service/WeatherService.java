package com.weather.weatherapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherapp.dto.WeatherDTO;
import com.weather.weatherapp.model.WeatherData;
import com.weather.weatherapp.util.Util;

@Service
public class WeatherService {
	
	@Value("${app.url}")
	public String appUrl;

	@Value("${app.id}")
	public String id;
	
	/* 	
	 * This method do a HTTP GET petition to the OpenWeather API
	 * @param String city, is the name of a city i.e. London
	 * @return WeatherInfo object, that contains the weather information of a city
	 * 
	 * */
	public WeatherDTO getWeatherData(String city) throws Exception {							
		RestTemplate restTemplate = new RestTemplate();
        String urlHTTP = appUrl + city + id;
        WeatherData weatherData = restTemplate.getForObject(urlHTTP, WeatherData.class);
        WeatherDTO weatherDTO = Util.weatherDataToWeatherDTO(weatherData);
        return weatherDTO;
	}
	
}
