package ourmarket.models;

/**
 * ImageLibrary entity. @author MyEclipse Persistence Tools
 */

public class ImageLibrary implements java.io.Serializable {

	// Fields

	private long imageId;
	private Integer imageListId;
	private String imageSrc;

	// Constructors

	/** default constructor */
	public ImageLibrary() {
	}

	/** minimal constructor */
	public ImageLibrary(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	/** full constructor */
	public ImageLibrary(Integer imageListId, String imageSrc) {
		this.imageListId = imageListId;
		this.imageSrc = imageSrc;
	}

	// Property accessors

	public long getImageId() {
		return this.imageId;
	}

	public void setImageId(long imageId) {
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