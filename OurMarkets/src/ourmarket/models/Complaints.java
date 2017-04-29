package ourmarket.models;

import java.sql.Timestamp;

/**
 * Complaints entity. @author MyEclipse Persistence Tools
 */
public class Complaints extends AbstractComplaints implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Complaints() {
	}

	/** minimal constructor */
	public Complaints(String complainContent, Timestamp complainTime, String complainTitle, Short complainState) {
		super(complainContent, complainTime, complainTitle, complainState);
	}

	/** full constructor */
	public Complaints(Integer uid, Integer useUId, Long imageListId, String complainContent, Timestamp complainTime,
			String complainTitle, Short complainState) {
		super(uid, useUId, imageListId, complainContent, complainTime, complainTitle, complainState);
	}

}
