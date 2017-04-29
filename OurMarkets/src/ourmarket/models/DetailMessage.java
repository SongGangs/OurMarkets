package ourmarket.models;

import java.util.Date;

/**
 * DetailMessage entity. @author MyEclipse Persistence Tools
 */

public class DetailMessage implements java.io.Serializable {

	// Fields

	private long dmId;
	private Integer mid;
	private String mcontent;
	private Date mtime;

	// Constructors

	/** default constructor */
	public DetailMessage() {
	}

	/** minimal constructor */
	public DetailMessage(String mcontent, Date mtime) {
		this.mcontent = mcontent;
		this.mtime = mtime;
	}

	/** full constructor */
	public DetailMessage(Integer mid, String mcontent, Date mtime) {
		this.mid = mid;
		this.mcontent = mcontent;
		this.mtime = mtime;
	}

	// Property accessors

	public long getDmId() {
		return this.dmId;
	}

	public void setDmId(long dmId) {
		this.dmId = dmId;
	}

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMcontent() {
		return this.mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public Date getMtime() {
		return this.mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

}