package ourmarket.models;

import java.sql.Timestamp;

/**
 * Collection entity. @author MyEclipse Persistence Tools
 */
public class Collection extends AbstractCollection implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Collection() {
	}

	/** minimal constructor */
	public Collection(Timestamp ctime) {
		super(ctime);
	}

	/** full constructor */
	public Collection(Integer uid, Long gid, Timestamp ctime) {
		super(uid, gid, ctime);
	}

}
