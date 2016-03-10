package playground.seb.uml.impl;

import collections.HashTableCH;

import java.io.*;

/**
 * @author Gustaf Bohlin
 * This class reads the Media objects from a text file and fills a Hashtable with them
 */
public class MediaService {
	private HashTableCH<String, Media> table;

	/**
	 * Loads a HashTableCH with media objects read from the file path
	 * @param path path to the file containing all media objects
	 * @return A HashTableCH containing all Media objects
     */
	public HashTableCH<String, Media> loadMedia(String path) {
		String line;
		String[] object;
		String[] actors;
		Media media;
		table = new HashTableCH<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
			while ((line = bufferedReader.readLine()) != null) {
				object = line.split(";");
				if(object[0].equals("Bok")) {
					media = new Book(object[1], object[2], object[3], object[4]);
				} else {
					actors = new String[object.length - 4];
					for (int i = 4; i < object.length; i++)
						actors[i] = object[i];
					media = new DVD(object[1], object[2], object[3], actors);
				}
				table.put(media.getMediaID(), media);
			}
		}
		catch (FileNotFoundException exception ) {
			exception.printStackTrace();
			System.out.println("File not found at \"" + path + "\"");
		}
		catch (IOException exception) {
			exception.printStackTrace();
			System.out.println("Could not read file \"" + path + "\"");
		}

		return table;
	}
}
