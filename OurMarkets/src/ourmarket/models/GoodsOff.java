package ourmarket.models;

import java.util.Date;

/**
 * GoodsOff entity. @author MyEclipse Persistence Tools
 */

public class GoodsOff implements java.io.Serializable {

	// Fields

	private Short goffId;
	private Integer uid;
	private long gid;
	private String goffReason;
	private Date goffTime;

	// Constructors

	/** default constructor */
	public GoodsOff() {
	}

	/** minimal constructor */
	public GoodsOff(String goffReason, Date goffTime) {
		this.goffReason = goffReason;
		this.goffTime = goffTime;
	}

	/** full constructor */
	public GoodsOff(Integer uid, long gid, String goffReason, Date goffTime) {
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

	public long getGid() {
		return this.gid;
	}

	public void setGid(long gid) {
		this.gid = gid;
	}

	public String getGoffReason() {
		return this.goffReason;
	}

	public void setGoffReason(String goffReason) {
		this.goffReason = goffReason;
	}

	public Date getGoffTime() {
		return this.goffTime;
	}

	public void setGoffTime(Date goffTime) {
		this.goffTime = goffTime;
	}

}