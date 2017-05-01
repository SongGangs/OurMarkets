package ourmarket.models;

import java.util.Date;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Integer uid;
	private long gid;
	private Date otime;
	private float omoney;
	private short opayState;
	private Integer onum;
	private String ono;
	private short osendState;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Date otime, float omoney, short opayState, Integer onum, String ono, short osendState) {
		this.otime = otime;
		this.omoney = omoney;
		this.opayState = opayState;
		this.onum = onum;
		this.ono = ono;
		this.osendState = osendState;
	}

	/** full constructor */
	public Orders(Integer uid, long gid, Date otime, float omoney, short opayState, Integer onum, String ono,
			short osendState) {
		this.uid = uid;
		this.gid = gid;
		this.otime = otime;
		this.omoney = omoney;
		this.opayState = opayState;
		this.onum = onum;
		this.ono = ono;
		this.osendState = osendState;
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

	public long getGid() {
		return this.gid;
	}

	public void setGid(long gid) {
		this.gid = gid;
	}

	public Date getOtime() {
		return this.otime;
	}

	public void setOtime(Date otime) {
		this.otime = otime;
	}

	public float getOmoney() {
		return this.omoney;
	}

	public void setOmoney(float omoney) {
		this.omoney = omoney;
	}

	public short getOpayState() {
		return this.opayState;
	}

	public void setOpayState(short opayState) {
		this.opayState = opayState;
	}

	public Integer getOnum() {
		return this.onum;
	}

	public void setOnum(Integer onum) {
		this.onum = onum;
	}

	public String getOno() {
		return this.ono;
	}

	public void setOno(String ono) {
		this.ono = ono;
	}

	public short getOsendState() {
		return this.osendState;
	}

	public void setOsendState(short osendState) {
		this.osendState = osendState;
	}

}