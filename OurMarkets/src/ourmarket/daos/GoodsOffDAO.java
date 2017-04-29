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

import ourmarket.models.GoodsOff;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsOff entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see ourmarket.models.GoodsOff
 * @author MyEclipse Persistence Tools
 */
@Repository
public class GoodsOffDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GoodsOffDAO.class);
	// property constants
	public static final String UID = "uid";
	public static final String GID = "gid";
	public static final String GOFF_REASON = "goffReason";

	public void save(GoodsOff transientInstance) {
		log.debug("saving GoodsOff instance");
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

	public void delete(GoodsOff persistentInstance) {
		log.debug("deleting GoodsOff instance");
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

	public GoodsOff findById(java.lang.Short id) {
		log.debug("getting GoodsOff instance with id: " + id);
		try {
			GoodsOff instance = (GoodsOff) getSession().get("ourmarket.models.GoodsOff", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(GoodsOff instance) {
		log.debug("finding GoodsOff instance by example");
		try {
			List results = getSession().createCriteria("ourmarket.models.GoodsOff").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding GoodsOff instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from GoodsOff as model where model." + propertyName + "= ?";
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

	public List findByGoffReason(Object goffReason) {
		return findByProperty(GOFF_REASON, goffReason);
	}

	public List findAll() {
		log.debug("finding all GoodsOff instances");
		try {
			String queryString = "from GoodsOff";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GoodsOff merge(GoodsOff detachedInstance) {
		log.debug("merging GoodsOff instance");
		try {
			GoodsOff result = (GoodsOff) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GoodsOff instance) {
		log.debug("attaching dirty GoodsOff instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GoodsOff instance) {
		log.debug("attaching clean GoodsOff instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}