package ourmarket.models;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String unickName, String uphone, String upassword) {
		super(unickName, uphone, upassword);
	}

	/** full constructor */
	public User(Integer rid, Long imageListId, String unickName, String uphone, String uemial, Integer ucredit,
			Short ugender, String upassword) {
		super(rid, imageListId, unickName, uphone, uemial, ucredit, ugender, upassword);
	}

}
