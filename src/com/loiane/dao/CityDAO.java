package com.loiane.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.loiane.model.City;

/**
 * City DAO class
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Repository
public class CityDAO extends BaseDAO{

	/**
	 * Get list of all cities from a state
	 * @param stateId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<City> getCityListByState(int stateId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(City.class);
		criteria.add(Restrictions.eq("stateId", stateId));
		
		return this.getHibernateTemplate().findByCriteria(criteria);
		
	}
	
	/**
	 * Get list of all cities
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<City> getCityList() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(City.class);
		
		return this.getHibernateTemplate().findByCriteria(criteria);
		
	}
}
