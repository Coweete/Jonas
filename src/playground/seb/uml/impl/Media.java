package playground.seb.uml.impl;

/**
 * Created by Sebastian Börebäck on 2016-03-09.
 */
public abstract class Media {
	private String mediaID;
	private String title;
	private String year;
	private boolean borrowed;

	public Media(String mediaID, String title, String year){
		this.mediaID = mediaID;
		this.title = title;
		this.year = year;
	}

	public String getMediaID() {
		return this.mediaID;
	}

	public String getTitle() {
		return this.title;
	}

	public String getYear() {
		return this.year;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public boolean equals(Object obj) {
		Media media = (Media) obj;
		return mediaID.equals(media.getMediaID());
	}
}
