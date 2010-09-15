package com.loiane.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.loiane.model.State;

/**
 * State DAO class
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Repository
public class StateDAO extends BaseDAO{

	/**
	 * Get list of all states
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<State> getStateList() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(State.class);
		
		return this.getHibernateTemplate().findByCriteria(criteria);
		
	}
	
}
