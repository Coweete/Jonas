package playground.seb.uml.impl;

import collections.HashTableCH;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * @author Gustaf Bohlin
 *         This class reads the Media objects from a text file and fills a Hashtable with them
 */
public class MediaService {
    private HashTableCH<String, Media> table;
    private String path;

    public MediaService(String path) {
        this.path = this.getClass().getResource("/" + path).getPath();
    }

    public void loadMedia() throws IOException {
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
                actors = new String[object.length - 4];
                for (int i = 4; i < object.length; i++)
                    actors[i] = object[i];
                media = new DVD(object[1], object[2], object[3], actors);
            }
            table.put(media.getMediaID(), media);
        }

        return table;
    }

    public Media getMedia(String mediaID) {
        return this.table.get(mediaID);
    }
}
