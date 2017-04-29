package ourmarket.models;

import java.util.Date;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */

public class Comments implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer uid;
	private long imageListId;
	private long gid;
	private String comments;
	private Date commentTime;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(String comments, Date commentTime) {
		this.comments = comments;
		this.commentTime = commentTime;
	}

	/** full constructor */
	public Comments(Integer uid, long imageListId, long gid, String comments, Date commentTime) {
		this.uid = uid;
		this.imageListId = imageListId;
		this.gid = gid;
		this.comments = comments;
		this.commentTime = commentTime;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public long getImageListId() {
		return this.imageListId;
	}

	public void setImageListId(long imageListId) {
		this.imageListId = imageListId;
	}

	public long getGid() {
		return this.gid;
	}

	public void setGid(long gid) {
		this.gid = gid;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

}