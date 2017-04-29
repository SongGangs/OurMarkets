package ourmarket.models;

/**
 * AbstractRole entity provides the base persistence definition of the Role
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRole implements java.io.Serializable {

	// Fields

	private Short rid;
	private String rinfo;

	// Constructors

	/** default constructor */
	public AbstractRole() {
	}

	/** full constructor */
	public AbstractRole(String rinfo) {
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