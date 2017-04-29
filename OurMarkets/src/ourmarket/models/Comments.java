package ourmarket.models;

import java.sql.Timestamp;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */
public class Comments extends AbstractComments implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(String comments, Timestamp commentTime) {
		super(comments, commentTime);
	}

	/** full constructor */
	public Comments(Integer uid, Long imageListId, Long gid, String comments, Timestamp commentTime) {
		super(uid, imageListId, gid, comments, commentTime);
	}

}
