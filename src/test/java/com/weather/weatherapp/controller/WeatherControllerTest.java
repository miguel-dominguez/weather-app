package com.weather.weatherapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import com.weather.weatherapp.service.WeatherService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
@TestPropertySource(locations = "classpath:test.properties")
public class WeatherControllerTest {
	
	@InjectMocks
	WeatherController weatherController = new WeatherController();

	@Mock
	WeatherService weatherService = new WeatherService();

	@Mock
	View mockView;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);		
		mockMvc = MockMvcBuilders.standaloneSetup(weatherController).setSingleView(mockView).build();
	}

	@Test
	public void getWeatherInfoCall200() throws IllegalArgumentException, InvocationTargetException, Exception {		
		mockMvc.perform(get("/getWeatherInfo").param("city", "London"))
			.andExpect(status().isOk())
			.andExpect(view().name("weather"));
	}
	
	@Test
	public void getWeatherInfoBadRequest400() throws IllegalArgumentException, InvocationTargetException, Exception {		
		mockMvc.perform(get("/getWeatherInfo"))
			.andExpect(status().isBadRequest())
			.andExpect(view().name("error"));
	}
	
}
