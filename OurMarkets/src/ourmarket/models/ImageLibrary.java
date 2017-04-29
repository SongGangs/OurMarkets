package ourmarket.models;

/**
 * ImageLibrary entity. @author MyEclipse Persistence Tools
 */
public class ImageLibrary extends AbstractImageLibrary implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ImageLibrary() {
	}

	/** minimal constructor */
	public ImageLibrary(String imageSrc) {
		super(imageSrc);
	}

	/** full constructor */
	public ImageLibrary(Integer imageListId, String imageSrc) {
		super(imageListId, imageSrc);
	}

}
