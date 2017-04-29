package ourmarket.models;

import java.sql.Timestamp;

/**
 * GoodsReturn entity. @author MyEclipse Persistence Tools
 */
public class GoodsReturn extends AbstractGoodsReturn implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public GoodsReturn() {
	}

	/** minimal constructor */
	public GoodsReturn(String rreason, Short rstate, Timestamp rtime) {
		super(rreason, rstate, rtime);
	}

	/** full constructor */
	public GoodsReturn(Integer oid, String rreason, Short rstate, Timestamp rtime) {
		super(oid, rreason, rstate, rtime);
	}

}
