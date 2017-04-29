package ourmarket.daos;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ourmarket.hibernate.HibernateSessionFactory;

/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
@Repository
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		//FIXME: Implement this method
		return HibernateSessionFactory.getSession();
	}
	
}