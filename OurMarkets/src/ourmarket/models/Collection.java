package ourmarket.models;

import java.util.Date;

/**
 * Collection entity. @author MyEclipse Persistence Tools
 */

public class Collection implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer uid;
	private long gid;
	private Date ctime;

	// Constructors

	/** default constructor */
	public Collection() {
	}

	/** minimal constructor */
	public Collection(Date ctime) {
		this.ctime = ctime;
	}

	/** full constructor */
	public Collection(Integer uid, long gid, Date ctime) {
		this.uid = uid;
		this.gid = gid;
		this.ctime = ctime;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
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

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

}