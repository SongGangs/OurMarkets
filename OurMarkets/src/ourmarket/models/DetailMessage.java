package ourmarket.models;

import java.sql.Timestamp;

/**
 * DetailMessage entity. @author MyEclipse Persistence Tools
 */
public class DetailMessage extends AbstractDetailMessage implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public DetailMessage() {
	}

	/** minimal constructor */
	public DetailMessage(String mcontent, Timestamp mtime) {
		super(mcontent, mtime);
	}

	/** full constructor */
	public DetailMessage(Integer mid, String mcontent, Timestamp mtime) {
		super(mid, mcontent, mtime);
	}

}
