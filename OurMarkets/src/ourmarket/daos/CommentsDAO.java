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

import ourmarket.models.Comments;

/**
 * A data access object (DAO) providing persistence and search support for
 * Comments entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see ourmarket.models.Comments
 * @author MyEclipse Persistence Tools
 */
@Repository
public class CommentsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentsDAO.class);
	// property constants
	public static final String UID = "uid";
	public static final String IMAGE_LIST_ID = "imageListId";
	public static final String GID = "gid";
	public static final String COMMENTS = "comments";

	public void save(Comments transientInstance) {
		log.debug("saving Comments instance");
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

	public void delete(Comments persistentInstance) {
		log.debug("deleting Comments instance");
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

	public Comments findById(java.lang.Integer id) {
		log.debug("getting Comments instance with id: " + id);
		try {
			Comments instance = (Comments) getSession().get("ourmarket.models.Comments", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Comments instance) {
		log.debug("finding Comments instance by example");
		try {
			List results = getSession().createCriteria("ourmarket.models.Comments").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Comments instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Comments as model where model." + propertyName + "= ?";
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

	public List findByImageListId(Object imageListId) {
		return findByProperty(IMAGE_LIST_ID, imageListId);
	}

	public List findByGid(Object gid) {
		return findByProperty(GID, gid);
	}

	public List findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List findAll() {
		log.debug("finding all Comments instances");
		try {
			String queryString = "from Comments";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Comments merge(Comments detachedInstance) {
		log.debug("merging Comments instance");
		try {
			Comments result = (Comments) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Comments instance) {
		log.debug("attaching dirty Comments instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Comments instance) {
		log.debug("attaching clean Comments instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}