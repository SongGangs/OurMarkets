package ourmarket.models;

/**
 * AbstractImageLibrary entity provides the base persistence definition of the
 * ImageLibrary entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractImageLibrary implements java.io.Serializable {

	// Fields

	private Long imageId;
	private Integer imageListId;
	private String imageSrc;

	// Constructors

	/** default constructor */
	public AbstractImageLibrary() {
	}

	/** minimal constructor */
	public AbstractImageLibrary(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	/** full constructor */
	public AbstractImageLibrary(Integer imageListId, String imageSrc) {
		this.imageListId = imageListId;
		this.imageSrc = imageSrc;
	}

	// Property accessors

	public Long getImageId() {
		return this.imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public Integer getImageListId() {
		return this.imageListId;
	}

	public void setImageListId(Integer imageListId) {
		this.imageListId = imageListId;
	}

	public String getImageSrc() {
		return this.imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

}