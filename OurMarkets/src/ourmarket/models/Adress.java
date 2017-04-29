package ourmarket.models;

/**
 * Adress entity. @author MyEclipse Persistence Tools
 */
public class Adress extends AbstractAdress implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Adress() {
	}

	/** minimal constructor */
	public Adress(String ainfo, Short astate) {
		super(ainfo, astate);
	}

	/** full constructor */
	public Adress(Integer uid, String ainfo, Short astate) {
		super(uid, ainfo, astate);
	}

}
