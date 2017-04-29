package ourmarket.models;

import java.sql.Timestamp;

/**
 * AbstractGoodsOff entity provides the base persistence definition of the
 * GoodsOff entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGoodsOff implements java.io.Serializable {

	// Fields

	private Short goffId;
	private Integer uid;
	private Long gid;
	private String goffReason;
	private Timestamp goffTime;

	// Constructors

	/** default constructor */
	public AbstractGoodsOff() {
	}

	/** minimal constructor */
	public AbstractGoodsOff(String goffReason, Timestamp goffTime) {
		this.goffReason = goffReason;
		this.goffTime = goffTime;
	}

	/** full constructor */
	public AbstractGoodsOff(Integer uid, Long gid, String goffReason, Timestamp goffTime) {
		this.uid = uid;
		this.gid = gid;
		this.goffReason = goffReason;
		this.goffTime = goffTime;
	}

	// Property accessors

	public Short getGoffId() {
		return this.goffId;
	}

	public void setGoffId(Short goffId) {
		this.goffId = goffId;
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

	public String getGoffReason() {
		return this.goffReason;
	}

	public void setGoffReason(String goffReason) {
		this.goffReason = goffReason;
	}

	public Timestamp getGoffTime() {
		return this.goffTime;
	}

	public void setGoffTime(Timestamp goffTime) {
		this.goffTime = goffTime;
	}

}