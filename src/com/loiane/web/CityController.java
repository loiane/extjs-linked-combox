package com.loiane.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loiane.service.CityService;

/**
 * Controller - Spring
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Controller
@RequestMapping(value="/city")
public class CityController {

	private CityService cityService;

	@RequestMapping(value="/getCitiesByState.action")
	public @ResponseBody Map<String,? extends Object> getCitiesByState(@RequestParam int stateId) throws Exception {

		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		
		try{
			
			modelMap.put("data", cityService.getCityListByState(stateId));
			
			return modelMap;

		} catch (Exception e) {
			
			e.printStackTrace();
			
			modelMap.put("success", false);

			return modelMap;
		}
	}
	
	@RequestMapping(value="/getAllCities.action")
	public @ResponseBody Map<String,? extends Object> getAllCities() throws Exception {

		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		
		try{
			
			modelMap.put("data", cityService.getCityList());
			
			return modelMap;

		} catch (Exception e) {
			
			e.printStackTrace();
			
			modelMap.put("success", false);

			return modelMap;
		}
	}
	
	@Autowired
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
}
