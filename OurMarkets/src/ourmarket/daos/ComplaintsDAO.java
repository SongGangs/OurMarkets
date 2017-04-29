package ourmarket.daos;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ourmarket.models.Complaints;

/**
 * A data access object (DAO) providing persistence and search support for
 * Complaints entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see ourmarket.models.Complaints
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ComplaintsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ComplaintsDAO.class);
	// property constants
	public static final String UID = "uid";
	public static final String USE_UID = "useUId";
	public static final String IMAGE_LIST_ID = "imageListId";
	public static final String COMPLAIN_CONTENT = "complainContent";
	public static final String COMPLAIN_TITLE = "complainTitle";
	public static final String COMPLAIN_STATE = "complainState";

	public void save(Complaints transientInstance) {
		log.debug("saving Complaints instance");
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

	public void delete(Complaints persistentInstance) {
		log.debug("deleting Complaints instance");
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

	public Complaints findById(java.lang.Integer id) {
		log.debug("getting Complaints instance with id: " + id);
		try {
			Complaints instance = (Complaints) getSession().get("ourmarket.models.Complaints", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Complaints instance) {
		log.debug("finding Complaints instance by example");
		try {
			List results = getSession().createCriteria("ourmarket.models.Complaints").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Complaints instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Complaints as model where model." + propertyName + "= ?";
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

	public List findByUseUId(Object useUId) {
		return findByProperty(USE_UID, useUId);
	}

	public List findByImageListId(Object imageListId) {
		return findByProperty(IMAGE_LIST_ID, imageListId);
	}

	public List findByComplainContent(Object complainContent) {
		return findByProperty(COMPLAIN_CONTENT, complainContent);
	}

	public List findByComplainTitle(Object complainTitle) {
		return findByProperty(COMPLAIN_TITLE, complainTitle);
	}

	public List findByComplainState(Object complainState) {
		return findByProperty(COMPLAIN_STATE, complainState);
	}

	public List findAll() {
		log.debug("finding all Complaints instances");
		try {
			String queryString = "from Complaints";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Complaints merge(Complaints detachedInstance) {
		log.debug("merging Complaints instance");
		try {
			Complaints result = (Complaints) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Complaints instance) {
		log.debug("attaching dirty Complaints instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Complaints instance) {
		log.debug("attaching clean Complaints instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}