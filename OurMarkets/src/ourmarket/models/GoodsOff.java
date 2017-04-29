package ourmarket.models;

import java.sql.Timestamp;

/**
 * GoodsOff entity. @author MyEclipse Persistence Tools
 */
public class GoodsOff extends AbstractGoodsOff implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public GoodsOff() {
	}

	/** minimal constructor */
	public GoodsOff(String goffReason, Timestamp goffTime) {
		super(goffReason, goffTime);
	}

	/** full constructor */
	public GoodsOff(Integer uid, Long gid, String goffReason, Timestamp goffTime) {
		super(uid, gid, goffReason, goffTime);
	}

}
