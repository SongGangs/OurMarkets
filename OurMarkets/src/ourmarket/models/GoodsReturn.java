package ourmarket.models;

import java.util.Date;

/**
 * GoodsReturn entity. @author MyEclipse Persistence Tools
 */

public class GoodsReturn implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Integer oid;
	private String rreason;
	private short rstate;
	private Date rtime;

	// Constructors

	/** default constructor */
	public GoodsReturn() {
	}

	/** minimal constructor */
	public GoodsReturn(String rreason, short rstate, Date rtime) {
		this.rreason = rreason;
		this.rstate = rstate;
		this.rtime = rtime;
	}

	/** full constructor */
	public GoodsReturn(Integer oid, String rreason, short rstate, Date rtime) {
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

	public short getRstate() {
		return this.rstate;
	}

	public void setRstate(short rstate) {
		this.rstate = rstate;
	}

	public Date getRtime() {
		return this.rtime;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}

}