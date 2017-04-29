package ourmarket.models;

import java.sql.Timestamp;

/**
 * AbstractComments entity provides the base persistence definition of the
 * Comments entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractComments implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer uid;
	private Long imageListId;
	private Long gid;
	private String comments;
	private Timestamp commentTime;

	// Constructors

	/** default constructor */
	public AbstractComments() {
	}

	/** minimal constructor */
	public AbstractComments(String comments, Timestamp commentTime) {
		this.comments = comments;
		this.commentTime = commentTime;
	}

	/** full constructor */
	public AbstractComments(Integer uid, Long imageListId, Long gid, String comments, Timestamp commentTime) {
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

	public Long getImageListId() {
		return this.imageListId;
	}

	public void setImageListId(Long imageListId) {
		this.imageListId = imageListId;
	}

	public Long getGid() {
		return this.gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}