package ourmarket.models;

import java.sql.Timestamp;

/**
 * AbstractCollection entity provides the base persistence definition of the
 * Collection entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCollection implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer uid;
	private Long gid;
	private Timestamp ctime;

	// Constructors

	/** default constructor */
	public AbstractCollection() {
	}

	/** minimal constructor */
	public AbstractCollection(Timestamp ctime) {
		this.ctime = ctime;
	}

	/** full constructor */
	public AbstractCollection(Integer uid, Long gid, Timestamp ctime) {
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

	public Long getGid() {
		return this.gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public Timestamp getCtime() {
		return this.ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

}