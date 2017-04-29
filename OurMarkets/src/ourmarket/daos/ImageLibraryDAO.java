package ourmarket.daos;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ourmarket.models.ImageLibrary;

/**
 * A data access object (DAO) providing persistence and search support for
 * ImageLibrary entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see ourmarket.models.ImageLibrary
 * @author MyEclipse Persistence Tools
 */
@Repository
public class ImageLibraryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ImageLibraryDAO.class);
	// property constants
	public static final String IMAGE_LIST_ID = "imageListId";
	public static final String IMAGE_SRC = "imageSrc";

	public void save(ImageLibrary transientInstance) {
		log.debug("saving ImageLibrary instance");
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

	public void delete(ImageLibrary persistentInstance) {
		log.debug("deleting ImageLibrary instance");
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

	public ImageLibrary findById(java.lang.Long id) {
		log.debug("getting ImageLibrary instance with id: " + id);
		try {
			ImageLibrary instance = (ImageLibrary) getSession().get("ourmarket.models.ImageLibrary", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ImageLibrary instance) {
		log.debug("finding ImageLibrary instance by example");
		try {
			List results = getSession().createCriteria("ourmarket.models.ImageLibrary").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ImageLibrary instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from ImageLibrary as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByImageListId(Object imageListId) {
		return findByProperty(IMAGE_LIST_ID, imageListId);
	}

	public List findByImageSrc(Object imageSrc) {
		return findByProperty(IMAGE_SRC, imageSrc);
	}

	public List findAll() {
		log.debug("finding all ImageLibrary instances");
		try {
			String queryString = "from ImageLibrary";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ImageLibrary merge(ImageLibrary detachedInstance) {
		log.debug("merging ImageLibrary instance");
		try {
			ImageLibrary result = (ImageLibrary) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ImageLibrary instance) {
		log.debug("attaching dirty ImageLibrary instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ImageLibrary instance) {
		log.debug("attaching clean ImageLibrary instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}