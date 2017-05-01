package ourmarket.daos;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ourmarket.models.Orders;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orders entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see ourmarket.models.Orders
 * @author MyEclipse Persistence Tools
 */
@Repository
public class OrdersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OrdersDAO.class);
	// property constants
	public static final String UID = "uid";
	public static final String GID = "gid";
	public static final String OMONEY = "omoney";
	public static final String OPAY_STATE = "opayState";
	public static final String ONUM = "onum";
	public static final String ONO = "ono";
	public static final String OSEND_STATE = "osendState";

	public void save(Orders transientInstance) {
		log.debug("saving Orders instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().save(transientInstance);
			transaction.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Orders persistentInstance) {
		log.debug("deleting Orders instance");
		try {
			Transaction transaction = getSession().beginTransaction();
			getSession().delete(persistentInstance);
			transaction.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orders findById(java.lang.Integer id) {
		log.debug("getting Orders instance with id: " + id);
		try {
			Orders instance = (Orders) getSession().get("ourmarket.models.Orders", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Orders instance) {
		log.debug("finding Orders instance by example");
		try {
			List results = getSession().createCriteria("ourmarket.models.Orders").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Orders instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Orders as model where model." + propertyName + "= ?";
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

	public List findByGid(Object gid) {
		return findByProperty(GID, gid);
	}

	public List findByOmoney(Object omoney) {
		return findByProperty(OMONEY, omoney);
	}

	public List findByOpayState(Object opayState) {
		return findByProperty(OPAY_STATE, opayState);
	}

	public List findByOnum(Object onum) {
		return findByProperty(ONUM, onum);
	}

	public List findByOno(Object ono) {
		return findByProperty(ONO, ono);
	}

	public List findByOsendState(Object osendState) {
		return findByProperty(OSEND_STATE, osendState);
	}

	public List findAll() {
		log.debug("finding all Orders instances");
		try {
			String queryString = "from Orders";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orders merge(Orders detachedInstance) {
		log.debug("merging Orders instance");
		try {
			Orders result = (Orders) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orders instance) {
		log.debug("attaching dirty Orders instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orders instance) {
		log.debug("attaching clean Orders instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}