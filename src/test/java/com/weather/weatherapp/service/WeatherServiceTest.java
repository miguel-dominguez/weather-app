package com.weather.weatherapp.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.weather.weatherapp.dto.WeatherDTO;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.properties")
public class WeatherServiceTest {

	private WeatherService weatherService;

	@Value("${app.url}")
	public String appUrl;

	@Value("${app.id}")
	public String id;

	@Before
	public void setUp() {
		weatherService = new WeatherService();
		ReflectionTestUtils.setField(weatherService, "appUrl", appUrl);
		ReflectionTestUtils.setField(weatherService, "id", id);
	}

	@Test
	public void getWeatherDataTest() throws Exception {
		WeatherDTO data = weatherService.getWeatherData("London");
		assertEquals("London", data.getCity());
	}

}
