package testing.seb;

import Jonas.Model.Book;
import Jonas.Model.DVD;
import Jonas.Model.IMediaService;
import Jonas.Model.Media;
import collections.HashTableCH;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Gustaf Bohlin
 *         This class reads the Media objects from a text file and fills a Hashtable with them
 */
public class DummyMediaService implements IMediaService {
    private HashTableCH<String, Media> table;
    private String path;

    public DummyMediaService(String path) {
	    System.out.println(getClass().getClassLoader().getResource(path));
	    this.path = getClass().getClassLoader().getResource(path).getPath();
    }

    @Override
    public void loadMedia() throws IOException {
        System.out.println(path);
        loadMedia(path);
    }

    /**
     * Loads a HashTableCH with media objects read from the file path
     *
     * @param path path to the file containing all media objects
     * @return A HashTableCH containing all Media objects
     */
    private HashTableCH<String, Media> loadMedia(String path) throws IOException {
        String line;
        String[] object;
        String[] actors;
        Media media;
        table = new HashTableCH<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
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
