package ourmarket.models;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Short rid;
	private String rinfo;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String rinfo) {
		this.rinfo = rinfo;
	}

	// Property accessors

	public Short getRid() {
		return this.rid;
	}

	public void setRid(Short rid) {
		this.rid = rid;
	}

	public String getRinfo() {
		return this.rinfo;
	}

	public void setRinfo(String rinfo) {
		this.rinfo = rinfo;
	}

}