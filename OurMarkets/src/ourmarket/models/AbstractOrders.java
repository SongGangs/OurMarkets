package ourmarket.models;

import java.sql.Timestamp;

/**
 * AbstractOrders entity provides the base persistence definition of the Orders
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOrders implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Integer uid;
	private Long gid;
	private Timestamp otime;
	private Float omoney;
	private Short ostate;
	private Integer onum;

	// Constructors

	/** default constructor */
	public AbstractOrders() {
	}

	/** minimal constructor */
	public AbstractOrders(Timestamp otime, Float omoney, Short ostate, Integer onum) {
		this.otime = otime;
		this.omoney = omoney;
		this.ostate = ostate;
		this.onum = onum;
	}

	/** full constructor */
	public AbstractOrders(Integer uid, Long gid, Timestamp otime, Float omoney, Short ostate, Integer onum) {
		this.uid = uid;
		this.gid = gid;
		this.otime = otime;
		this.omoney = omoney;
		this.ostate = ostate;
		this.onum = onum;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Long getGid() {
		return this.gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public Timestamp getOtime() {
		return this.otime;
	}

	public void setOtime(Timestamp otime) {
		this.otime = otime;
	}

	public Float getOmoney() {
		return this.omoney;
	}

	public void setOmoney(Float omoney) {
		this.omoney = omoney;
	}

	public Short getOstate() {
		return this.ostate;
	}

	public void setOstate(Short ostate) {
		this.ostate = ostate;
	}

	public Integer getOnum() {
		return this.onum;
	}

	public void setOnum(Integer onum) {
		this.onum = onum;
	}

}