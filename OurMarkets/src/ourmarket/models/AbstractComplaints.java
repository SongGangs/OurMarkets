package ourmarket.models;

import java.sql.Timestamp;

/**
 * AbstractComplaints entity provides the base persistence definition of the
 * Complaints entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractComplaints implements java.io.Serializable {

	// Fields

	private Integer complainId;
	private Integer uid;
	private Integer useUId;
	private Long imageListId;
	private String complainContent;
	private Timestamp complainTime;
	private String complainTitle;
	private Short complainState;

	// Constructors

	/** default constructor */
	public AbstractComplaints() {
	}

	/** minimal constructor */
	public AbstractComplaints(String complainContent, Timestamp complainTime, String complainTitle,
			Short complainState) {
		this.complainContent = complainContent;
		this.complainTime = complainTime;
		this.complainTitle = complainTitle;
		this.complainState = complainState;
	}

	/** full constructor */
	public AbstractComplaints(Integer uid, Integer useUId, Long imageListId, String complainContent,
			Timestamp complainTime, String complainTitle, Short complainState) {
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

	public Long getImageListId() {
		return this.imageListId;
	}

	public void setImageListId(Long imageListId) {
		this.imageListId = imageListId;
	}

	public String getComplainContent() {
		return this.complainContent;
	}

	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}

	public Timestamp getComplainTime() {
		return this.complainTime;
	}

	public void setComplainTime(Timestamp complainTime) {
		this.complainTime = complainTime;
	}

	public String getComplainTitle() {
		return this.complainTitle;
	}

	public void setComplainTitle(String complainTitle) {
		this.complainTitle = complainTitle;
	}

	public Short getComplainState() {
		return this.complainState;
	}

	public void setComplainState(Short complainState) {
		this.complainState = complainState;
	}

}