package com.weather.weatherapp.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilTest {

	@Test
	public void timestampToDateTest() {
		Util util = new Util();
		Long date = 1557327332l;
		String newDate = util.timestampToDate(date);
		assertEquals("08-05-2019", newDate);
	}
	
	@Test
	public void timestampToTimeTest() {
		Util util = new Util();
		Long date = 1557289225l;
		String newTime = util.timestampToTime(date);
		assertEquals("23:20 PM", newTime);
	}
	
}
