package com.loiane.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loiane.dao.CityDAO;
import com.loiane.model.City;

/**
 * City Service
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Service
public class CityService {

	private CityDAO cityDAO;

	/**
	 * Get list of all cities from a state
	 * @param stateId
	 * @return
	 */
	public List<City> getCityListByState(int stateId) {
		return cityDAO.getCityListByState(stateId);
	}
	
	/**
	 * Get list of all cities
	 * @return
	 */
	public List<City> getCityList() {
		return cityDAO.getCityList();
	}
	
	/**
	 * Spring use - DI
	 * @param companyDAO
	 */
	@Autowired
	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}
}
