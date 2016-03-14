package testing.seb;

import Jonas.Model.Book;
import Jonas.Model.DVD;
import Jonas.Model.IMediaService;
import Jonas.Model.Media;
import collections.HashTableCH;

import java.io.*;
import java.net.URISyntaxException;

/**
 * Dummy Class for testing.
 * @author Gustaf Bohlin, Sebastian Boreback
 *         This class reads the Media objects from a text file and fills a Hashtable with them
 */
public class DummyMediaService implements IMediaService {
	private HashTableCH<String, Media> table;
    private InputStream path;

    public DummyMediaService(String path) {
	    // TODO: 2016-03-12 :18:36 Here i want to print path of media
	    this.path = getClass().getResourceAsStream("/"+path);
    }

    @Override
    public void loadMedia() throws IOException, URISyntaxException {
        loadMedia(path);
    }

    /**
     * Loads a HashTableCH with media objects read from the file path
     *
     * @param path path to the file containing all media objects
     * @return A HashTableCH containing all Media objects
     */
    private HashTableCH<String, Media> loadMedia(InputStream path) throws IOException, URISyntaxException {
        String line;
        String[] object;
        String[] actors;
        Media media;

	    table = new HashTableCH<>();
	    BufferedReader bufferedReader = null;
	    try {
		    bufferedReader = new BufferedReader(new InputStreamReader(path));
	    } catch (Exception e) {
		    throw new FileNotFoundException("Couldnt find MediaSerivce File");
	    }
	    while ((line = bufferedReader.readLine()) != null) {
            object = line.split(";");
            if (object[0].equals("Bok")) {
                media = new Book(object[1], object[2], object[3], object[4]);
            } else {
                actors = new String[object.length - 5];
                for (int i = 5; i < object.length; i++)
                    actors[i - 5] = object[i];
                media = new DVD(object[1], object[2], object[3], actors);
            }
	        // TODO: 2016-03-12 :18:04 Added so that you can see all the media in mediaService
	        System.out.println(media);
	        table.put(media.getMediaID(), media);
        }

        return table;
    }

    @Override
    public Media getMedia(String mediaID) {
        return this.table.get(mediaID);
    }
}
