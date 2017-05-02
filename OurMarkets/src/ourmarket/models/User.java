package ourmarket.models;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Integer rid;
	private Long imageListId;
	private String unickName;
	private String uphone;
	private String uemial;
	private Integer ucredit;
	private Short ugender;
	private String upassword;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String unickName, String uphone, String upassword) {
		this.unickName = unickName;
		this.uphone = uphone;
		this.upassword = upassword;
	}

	/** full constructor */
	public User(Integer rid, Long imageListId, String unickName, String uphone, String uemial, Integer ucredit,
			Short ugender, String upassword) {
		this.rid = rid;
		this.imageListId = imageListId;
		this.unickName = unickName;
		this.uphone = uphone;
		this.uemial = uemial;
		this.ucredit = ucredit;
		this.ugender = ugender;
		this.upassword = upassword;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Long getImageListId() {
		return this.imageListId;
	}

	public void setImageListId(Long imageListId) {
		this.imageListId = imageListId;
	}

	public String getUnickName() {
		return this.unickName;
	}

	public void setUnickName(String unickName) {
		this.unickName = unickName;
	}

	public String getUphone() {
		return this.uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUemial() {
		return this.uemial;
	}

	public void setUemial(String uemial) {
		this.uemial = uemial;
	}

	public Integer getUcredit() {
		return this.ucredit;
	}

	public void setUcredit(Integer ucredit) {
		this.ucredit = ucredit;
	}

	public Short getUgender() {
		return this.ugender;
	}

	public void setUgender(Short ugender) {
		this.ugender = ugender;
	}

	public String getUpassword() {
		return this.upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

}