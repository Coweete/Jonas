package playground.seb.uml.impl;

import collections.HashTableCH;

import java.io.*;

/**
 * Created by seb on 2016-03-10.
 */
public class MediaService {
	private HashTableCH<String, Media> table;

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
