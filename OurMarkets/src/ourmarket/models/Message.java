package ourmarket.models;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
public class Message extends AbstractMessage implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Integer uid1, Integer uid2) {
		super(uid1, uid2);
	}

}
