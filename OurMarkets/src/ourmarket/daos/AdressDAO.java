package ourmarket.daos;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ourmarket.models.Adress;

/**
 * A data access object (DAO) providing persistence and search support for
 * Adress entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see ourmarket.models.Adress
 * @author MyEclipse Persistence Tools
 */
@Repository
public class AdressDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AdressDAO.class);
	// property constants
	public static final String UID = "uid";
	public static final String AINFO = "ainfo";
	public static final String ASTATE = "astate";

	public void save(Adress transientInstance) {
		log.debug("saving Adress instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			getSession().save(transientInstance);
			transaction.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Adress persistentInstance) {
		log.debug("deleting Adress instance");
		try {
			Transaction transaction=getSession().beginTransaction();
			getSession().delete(persistentInstance);
			transaction.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Adress findById(java.lang.Long id) {
		log.debug("getting Adress instance with id: " + id);
		try {
			Adress instance = (Adress) getSession().get("ourmarket.models.Adress", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Adress instance) {
		log.debug("finding Adress instance by example");
		try {
			List results = getSession().createCriteria("ourmarket.models.Adress").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Adress instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Adress as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	public List findByAinfo(Object ainfo) {
		return findByProperty(AINFO, ainfo);
	}

	public List findByAstate(Object astate) {
		return findByProperty(ASTATE, astate);
	}

	public List findAll() {
		log.debug("finding all Adress instances");
		try {
			String queryString = "from Adress";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Adress merge(Adress detachedInstance) {
		log.debug("merging Adress instance");
		try {
			Adress result = (Adress) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Adress instance) {
		log.debug("attaching dirty Adress instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Adress instance) {
		log.debug("attaching clean Adress instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}