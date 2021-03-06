package Jonas.Model;


/**
 * Model representing the Media.
 * @author Anton
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

	public void setBorrowed(boolean borrowed) { this.borrowed = borrowed; }


	public boolean equals(Object obj) {
		Media media = (Media) obj;
		return mediaID.equals(media.getMediaID());
	}

	/**
	 * Converts the Media to a string
	 * @return a string object of Media
	 */
	@Override
	public String toString() {
		return "Media{" +
				"mediaID='" + mediaID + '\'' +
				", title='" + title + '\'' +
				", year='" + year + '\'' +
				", borrowed=" + borrowed +
				'}';
	}
}
