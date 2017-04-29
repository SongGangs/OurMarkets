package ourmarket.models;

import java.util.Date;

/**
 * Complaints entity. @author MyEclipse Persistence Tools
 */

public class Complaints implements java.io.Serializable {

	// Fields

	private Integer complainId;
	private Integer uid;
	private Integer useUId;
	private long imageListId;
	private String complainContent;
	private Date complainTime;
	private String complainTitle;
	private short complainState;

	// Constructors

	/** default constructor */
	public Complaints() {
	}

	/** minimal constructor */
	public Complaints(String complainContent, Date complainTime, String complainTitle, short complainState) {
		this.complainContent = complainContent;
		this.complainTime = complainTime;
		this.complainTitle = complainTitle;
		this.complainState = complainState;
	}

	/** full constructor */
	public Complaints(Integer uid, Integer useUId, long imageListId, String complainContent, Date complainTime,
			String complainTitle, short complainState) {
		this.uid = uid;
		this.useUId = useUId;
		this.imageListId = imageListId;
		this.complainContent = complainContent;
		this.complainTime = complainTime;
		this.complainTitle = complainTitle;
		this.complainState = complainState;
	}

	// Property accessors

	public Integer getComplainId() {
		return this.complainId;
	}

	public void setComplainId(Integer complainId) {
		this.complainId = complainId;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getUseUId() {
		return this.useUId;
	}

	public void setUseUId(Integer useUId) {
		this.useUId = useUId;
	}

	public long getImageListId() {
		return this.imageListId;
	}

	public void setImageListId(long imageListId) {
		this.imageListId = imageListId;
	}

	public String getComplainContent() {
		return this.complainContent;
	}

	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}

	public Date getComplainTime() {
		return this.complainTime;
	}

	public void setComplainTime(Date complainTime) {
		this.complainTime = complainTime;
	}

	public String getComplainTitle() {
		return this.complainTitle;
	}

	public void setComplainTitle(String complainTitle) {
		this.complainTitle = complainTitle;
	}

	public short getComplainState() {
		return this.complainState;
	}

	public void setComplainState(short complainState) {
		this.complainState = complainState;
	}

}