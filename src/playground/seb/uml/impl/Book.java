package playground.seb.uml.impl;

/**
 * Created by Sebastian Börebäck on 2016-03-09.
 */
public class Book extends Media {
	private String author;

	public Book(String mediaID, String author, String title, String year){
		super(mediaID, title, year);
		this.author = author;

	}

	public String getMediaID() {
		return super.getMediaID();
	}

	public String getYear() {
		return super.getYear();
	}

	public String getTitle() {
		return super.getTitle();
	}

	@Override
	public boolean isBorrowed() {
		return super.isBorrowed();
	}

	public String getAuthor() {
		return this.author;
	}




}
