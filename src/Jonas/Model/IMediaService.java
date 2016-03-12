package Jonas.Model;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by seb on 2016-03-11.
 */
public interface IMediaService {
	/**
	 * Loads the Hashtable with the media objects
	 * @throws IOException
     */
	void loadMedia() throws IOException, URISyntaxException;

	/**
	 * returns the media object containing the ID mediaID
	 * @param mediaID the ID of the media object
	 * @return the media object
     */
	Media getMedia(String mediaID);
}
