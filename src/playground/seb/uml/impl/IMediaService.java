package playground.seb.uml.impl;

import java.io.IOException;

/**
 * Created by seb on 2016-03-11.
 */
public interface IMediaService {
	void loadMedia() throws IOException;

	Media getMedia(String mediaID);
}
