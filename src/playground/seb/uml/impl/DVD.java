package playground.seb.uml.impl;

/**
 * Created by Sebastian Börebäck on 2016-03-09.
 */
public class DVD extends Media {
	private String[] actors;

	public DVD(String mediaID, String title, String year, String[] actors){
		super(mediaID, title, year);
		this.actors = actors;
	}
	@Override
	public String getTitle() {
		return super.getTitle();
	}

	@Override
	public String getMediaID() {
		return super.getMediaID();
	}

	@Override
	public String getYear() {
		return super.getYear();
	}

	@Override
	public boolean isBorrowed() {
		return super.isBorrowed();
	}

	public String[] getActors() {
		return actors;
	}

}
