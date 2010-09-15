package com.loiane.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loiane.dao.StateDAO;
import com.loiane.model.State;

/**
 * State Service
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Service
public class StateService {

	private StateDAO stateDAO;

	/**
	 * Get list of all states
	 * @return
	 */
	public List<State> getStateList() {
		return stateDAO.getStateList();
	}
	
	/**
	 * Spring use - DI
	 * @param companyDAO
	 */
	@Autowired
	public void setStateDAO(StateDAO stateDAO) {
		this.stateDAO = stateDAO;
	}
}
