package ourmarket.models;

import java.sql.Timestamp;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
public class Orders extends AbstractOrders implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Timestamp otime, Float omoney, Short ostate, Integer onum) {
		super(otime, omoney, ostate, onum);
	}

	/** full constructor */
	public Orders(Integer uid, Long gid, Timestamp otime, Float omoney, Short ostate, Integer onum) {
		super(uid, gid, otime, omoney, ostate, onum);
	}

}
