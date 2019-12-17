package com.weather.weatherapp.dto;

import lombok.Getter;
import lombok.Setter;

public class WeatherDTO {

	@Getter
	@Setter
	String date;

	@Getter
	@Setter
	String city;

	@Getter
	@Setter
	String description;

	@Getter
	@Setter
	String temperatureCelcius;

	@Getter
	@Setter
	String temperatureFarenheit;

	@Getter
	@Setter
	String sunriseTime;

	@Getter
	@Setter
	String sunsetTime;

}
