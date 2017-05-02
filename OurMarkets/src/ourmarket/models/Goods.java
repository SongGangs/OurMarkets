package ourmarket.models;

import java.util.Date;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Long gid;
	private Integer uid;
	private Long imageListId;
	private String gname;
	private Integer gnum;
	private Integer gviewNum;
	private Date gproductTime;
	private String gtitle;
	private float gprice;
	private String gbrifeIntroduction;
	private short gstate;
	private short gtype;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(String gname, Integer gnum, Date gproductTime, String gtitle, float gprice, short gstate,
			short gtype) {
		this.gname = gname;
		this.gnum = gnum;
		this.gproductTime = gproductTime;
		this.gtitle = gtitle;
		this.gprice = gprice;
		this.gstate = gstate;
		this.gtype = gtype;
	}

	/** full constructor */
	public Goods(Integer uid, Long imageListId, String gname, Integer gnum, Integer gviewNum, Date gproductTime,
			String gtitle, float gprice, String gbrifeIntroduction, short gstate, short gtype) {
		this.uid = uid;
		this.imageListId = imageListId;
		this.gname = gname;
		this.gnum = gnum;
		this.gviewNum = gviewNum;
		this.gproductTime = gproductTime;
		this.gtitle = gtitle;
		this.gprice = gprice;
		this.gbrifeIntroduction = gbrifeIntroduction;
		this.gstate = gstate;
		this.gtype = gtype;
	}

	// Property accessors

	public Long getGid() {
		return this.gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
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

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getGnum() {
		return this.gnum;
	}

	public void setGnum(Integer gnum) {
		this.gnum = gnum;
	}

	public Integer getGviewNum() {
		return this.gviewNum;
	}

	public void setGviewNum(Integer gviewNum) {
		this.gviewNum = gviewNum;
	}

	public Date getGproductTime() {
		return this.gproductTime;
	}

	public void setGproductTime(Date gproductTime) {
		this.gproductTime = gproductTime;
	}

	public String getGtitle() {
		return this.gtitle;
	}

	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}

	public float getGprice() {
		return this.gprice;
	}

	public void setGprice(float gprice) {
		this.gprice = gprice;
	}

	public String getGbrifeIntroduction() {
		return this.gbrifeIntroduction;
	}

	public void setGbrifeIntroduction(String gbrifeIntroduction) {
		this.gbrifeIntroduction = gbrifeIntroduction;
	}

	public short getGstate() {
		return this.gstate;
	}

	public void setGstate(short gstate) {
		this.gstate = gstate;
	}

	public short getGtype() {
		return this.gtype;
	}

	public void setGtype(short gtype) {
		this.gtype = gtype;
	}

}