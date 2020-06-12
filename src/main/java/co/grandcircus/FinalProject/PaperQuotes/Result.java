package co.grandcircus.FinalProject.PaperQuotes;

import java.util.Arrays;

public class Result {
	
	private String quote;
	private String author;
	private Integer likes;
	private String[] tags;
	private Long pk;
	private String image;
	private String language;
	
	//@return GET quote
	public String getQuote() {
		return quote;
	}
	
	//@param SET quote
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	//@return GET author
	public String getAuthor() {
		return author;
	}
	
	//@param SET author
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//@return GET likes
	public Integer getLikes() {
		return likes;
	}
	
	//@param SET likes
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	//@return GET tags
	public String[] getTags() {
		return tags;
	}
	
	//@param SET tags
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	//@return GET pk
	public Long getPk() {
		return pk;
	}
	
	//@param SET pk
	public void setPk(Long pk) {
		this.pk = pk;
	}
	
	//@return GET image
	public String getImage() {
		return image;
	}
	
	//@param SET image
	public void setImage(String image) {
		this.image = image;
	}
	
	//@return GET language
	public String getLanguage() {
		return language;
	}
	
	//@param SET language
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Result [quote=" + quote + ", author=" + author + ", likes=" + likes + ", tags=" + Arrays.toString(tags)
				+ ", pk=" + pk + ", image=" + image + ", language=" + language + "]";
	}
	
	
	

}
