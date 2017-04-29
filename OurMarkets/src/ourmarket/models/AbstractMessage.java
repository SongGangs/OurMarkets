package ourmarket.models;

/**
 * AbstractMessage entity provides the base persistence definition of the
 * Message entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMessage implements java.io.Serializable {

	// Fields

	private Integer mid;
	private Integer uid1;
	private Integer uid2;

	// Constructors

	/** default constructor */
	public AbstractMessage() {
	}

	/** full constructor */
	public AbstractMessage(Integer uid1, Integer uid2) {
		this.uid1 = uid1;
		this.uid2 = uid2;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getUid1() {
		return this.uid1;
	}

	public void setUid1(Integer uid1) {
		this.uid1 = uid1;
	}

	public Integer getUid2() {
		return this.uid2;
	}

	public void setUid2(Integer uid2) {
		this.uid2 = uid2;
	}

}