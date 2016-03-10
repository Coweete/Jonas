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
	private String currentUser;

	/**
	 * Reads from file and places data in a BST
	 * @param path filepath to file with members
	 * @return Filled out memberTree, with all members added
	 **/
	@Override
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
	@Override
	public List<Member> getMembers(){
		return memberTree.values();
	}

	/**
	 * Fetches a specefied member through the use of their memberID
	 * @param key the memberID of the member to be fetched
	 **/
	@Override
	public Member getMember(String key){
		return memberTree.get(key);
	}

	/**
	 * Sets the current user to the input
	 * @param currentUser the user to be the current one
	 **/
	@Override
	public void setCurrentUser(String currentUser) {
		this.currentUser=currentUser;
	}

	/**
	 * Checks if the current user is in the the list of registered users
	 * @return true/false depending if the user exists
	 **/
	@Override
	public boolean userExists(){
		return memberTree.contains(currentUser);
	}

}
