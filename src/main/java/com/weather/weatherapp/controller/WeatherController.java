package com.weather.weatherapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.weather.weatherapp.dto.WeatherDTO;
import com.weather.weatherapp.model.WeatherData;
import com.weather.weatherapp.service.WeatherService;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping(value = "/")
	public String home() {
		return "index";
	}

	@GetMapping(value = "/getWeatherInfo")
	public String authenticateUser(@RequestParam("city") String city, Model model) throws Exception {
		WeatherDTO data = weatherService.getWeatherData(city);
		model.addAttribute("weatherDTO", data);
		return "weather";
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}

}
