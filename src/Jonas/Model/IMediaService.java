package Jonas.Model;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Interface representation of MediaSerivce
 * @author Gustaf
 */
public interface IMediaService {
	/**
	 * Loads the Hashtable with the media objects
	 * @throws IOException when file is not found
	 * @throws NullPointerException when file is not found
     */
	void loadMedia() throws IOException, URISyntaxException;

	/**
	 * returns the media object containing the ID mediaID
	 * @param mediaID the ID of the media object
	 * @return the media object
     */
	Media getMedia(String mediaID);
}
