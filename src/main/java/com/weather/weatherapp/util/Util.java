package com.weather.weatherapp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.weather.weatherapp.dto.WeatherDTO;
import com.weather.weatherapp.model.WeatherData;

public class Util {
	
	
	public static WeatherDTO weatherDataToWeatherDTO(WeatherData weatherData) {
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setDate(timestampToDate(new Long(weatherData.getDt())));
		weatherDTO.setCity(weatherData.getName());
		weatherDTO.setDescription(weatherData.getWeather().get(0).getDescription());
		Double kelvin = weatherData.getMain().getTemp();
		weatherDTO.setTemperatureCelcius(kelvinToCelcius(kelvin));
		weatherDTO.setTemperatureFarenheit(kelvinToFahrenheit(kelvin));
		weatherDTO.setSunriseTime(timestampToTime(new Long(weatherData.getSys().getSunrise())));
		weatherDTO.setSunsetTime(timestampToTime(new Long(weatherData.getSys().getSunset())));
		return weatherDTO; 
	}

	public static String timestampToDate(Long timestampDate) {
		// convert seconds to milliseconds
		Date date = new java.util.Date(timestampDate * 1000L);
		// the format of your date
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
		// give a timezone reference for formatting
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

	public static String timestampToTime(Long timestampDate) {
		Date date = new java.util.Date(timestampDate * 1000L);
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm a");		
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

	public static String kelvinToCelcius(Double degKelvin) {
		Double degCelcius;
		degCelcius = degKelvin - 273.15f;
		String result = String.format("%.2f", degCelcius);
		return result;
	}

	public static String kelvinToFahrenheit(Double degKelvin) {
		Double degFahrenheit;
		degFahrenheit = ((degKelvin - 273.15) * 9/5) + 32;
		String result = String.format("%.2f", degFahrenheit);
		return result;
	}

}
