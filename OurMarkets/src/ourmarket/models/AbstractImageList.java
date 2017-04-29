package ourmarket.models;

/**
 * AbstractImageList entity provides the base persistence definition of the
 * ImageList entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractImageList implements java.io.Serializable {

	// Fields

	private Long imageListId;

	// Constructors

	/** default constructor */
	public AbstractImageList() {
	}

	// Property accessors

	public Long getImageListId() {
		return this.imageListId;
	}

	public void setImageListId(Long imageListId) {
		this.imageListId = imageListId;
	}

}