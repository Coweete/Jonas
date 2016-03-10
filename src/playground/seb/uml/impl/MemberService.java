package playground.seb.uml.impl;

import collections.BinarySearchTree;
import collections.List;

import java.io.*;

/**
 * Reads a text file and places the nodes in a BinarySearchTree
 * @author Robin Johnsson
 */
public class MemberService implements IMemberService{
	private BinarySearchTree<String,Member> memberTree;

	/**
	 * Reads from file and places data in a BST
	 * @param path filepath to file with members
	 * @return Filled out memberTree, with all members added
	 **/
	public BinarySearchTree<String, Member> loadMember(String path) {
		memberTree = new BinarySearchTree<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(path), "UTF-8"));
			String[] parts;
			String text = br.readLine();
			while (text != null) {
				parts = text.split(";");
				Member mediaMember = new Member(parts[0],parts[1], parts[2]);
				memberTree.put(mediaMember.getMemberID(), mediaMember);
				text = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException exception ) {
			exception.printStackTrace();
			System.out.println("File not found at \"" + path + "\"");
		}catch (IOException e) {
			System.out.println(e);
		}
		return memberTree;
	}

	/**
	 * Returns a list of all registered members
	 * @return List of members
	 **/
	public List<Member> getMembers(){
		return memberTree.values();
	}

	/**
	 *
	 **/
	public Member getMember(String key){
		return memberTree.get(key);
	}
}
