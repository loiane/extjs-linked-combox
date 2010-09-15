package com.loiane.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loiane.service.StateService;

/**
 * Controller - Spring
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Controller
@RequestMapping(value="/state")
public class StateController {

	private StateService stateService;

	@RequestMapping(value="/view.action")
	public @ResponseBody Map<String,? extends Object> view() throws Exception {

		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		
		try{
			
			modelMap.put("data", stateService.getStateList());
			
			return modelMap;

		} catch (Exception e) {
			
			e.printStackTrace();
			
			modelMap.put("success", false);

			return modelMap;
		}
	}
	
	@Autowired
	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}
}
