package co.grandcirculs.PickedArticles;

public class PickedArticle {
	
	private String title;
	private String description;
	private String url;
	private String image;
	
	
	public PickedArticle() {}
	
	public PickedArticle(String title, String description, String url, String image) {
		super();
		this.title = title;
		this.description = description;
		this.url = url;
		this.image = image;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "PickedArticle [title=" + title + ", description=" + description + ", url=" + url + ", image=" + image + "]";
	}
	
	

}
