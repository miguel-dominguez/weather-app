package com.weather.weatherapp.dto;

public class WeatherDTO {
	
	String date;
	String city;
	String description;
	String temperatureCelcius;
	String temperatureFarenheit;
	String sunriseTime;
	String sunsetTime;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTemperatureCelcius() {
		return temperatureCelcius;
	}
	public void setTemperatureCelcius(String temperatureCelcius) {
		this.temperatureCelcius = temperatureCelcius;
	}
	public String getTemperatureFarenheit() {
		return temperatureFarenheit;
	}
	public void setTemperatureFarenheit(String temperatureFarenheit) {
		this.temperatureFarenheit = temperatureFarenheit;
	}
	public String getSunriseTime() {
		return sunriseTime;
	}
	public void setSunriseTime(String sunriseTime) {
		this.sunriseTime = sunriseTime;
	}
	public String getSunsetTime() {
		return sunsetTime;
	}
	public void setSunsetTime(String sunsetTime) {
		this.sunsetTime = sunsetTime;
	}

}
