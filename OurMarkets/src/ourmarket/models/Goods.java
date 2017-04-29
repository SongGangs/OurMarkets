package ourmarket.models;

import java.sql.Timestamp;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
public class Goods extends AbstractGoods implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(String gname, Integer gnum, Timestamp gproductTime, String gtitle, Float gprice, Short gstate,
			Short gtype) {
		super(gname, gnum, gproductTime, gtitle, gprice, gstate, gtype);
	}

	/** full constructor */
	public Goods(Integer uid, Long imageListId, String gname, Integer gnum, Integer gviewNum, Timestamp gproductTime,
			String gtitle, Float gprice, String gbrifeIntroduction, Short gstate, Short gtype) {
		super(uid, imageListId, gname, gnum, gviewNum, gproductTime, gtitle, gprice, gbrifeIntroduction, gstate, gtype);
	}

}
