package ourmarket.models;

import java.sql.Timestamp;

/**
 * AbstractGoodsReturn entity provides the base persistence definition of the
 * GoodsReturn entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGoodsReturn implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Integer oid;
	private String rreason;
	private Short rstate;
	private Timestamp rtime;

	// Constructors

	/** default constructor */
	public AbstractGoodsReturn() {
	}

	/** minimal constructor */
	public AbstractGoodsReturn(String rreason, Short rstate, Timestamp rtime) {
		this.rreason = rreason;
		this.rstate = rstate;
		this.rtime = rtime;
	}

	/** full constructor */
	public AbstractGoodsReturn(Integer oid, String rreason, Short rstate, Timestamp rtime) {
		this.oid = oid;
		this.rreason = rreason;
		this.rstate = rstate;
		this.rtime = rtime;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getRreason() {
		return this.rreason;
	}

	public void setRreason(String rreason) {
		this.rreason = rreason;
	}

	public Short getRstate() {
		return this.rstate;
	}

	public void setRstate(Short rstate) {
		this.rstate = rstate;
	}

	public Timestamp getRtime() {
		return this.rtime;
	}

	public void setRtime(Timestamp rtime) {
		this.rtime = rtime;
	}

}