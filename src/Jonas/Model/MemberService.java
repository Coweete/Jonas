package Jonas.Model;

import collections.BinarySearchTree;
import collections.List;

import java.io.*;

/**
 * Reads a text file and places the nodes in a BinarySearchTree
 *
 * @author Robin Johnsson
 */
public class MemberService implements IMemberService {
	private BinarySearchTree<String, Member> memberTree;
	private String currentUserID;
	private InputStream path;

	public MemberService(String path) {
		this.path = getClass().getResourceAsStream("/"+path);
	}

	public void loadMember() throws IOException {
		loadMember(path);
	}

	/**
	 * Reads from file and places data in a BST
	 *
	 * @param path file path to file with members
	 * @return Filled out memberTree, with all members added
	 **/
	private void loadMember(InputStream path) throws IOException {

		memberTree = new BinarySearchTree<>();
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(path));
		} catch (Exception e) {
			throw new FileNotFoundException("Couldnt find MemberService File");
		}

		String[] parts;
		String text = br.readLine();
		while (text != null) {
			parts = text.split(";");
			Member mediaMember = new Member(parts[0], parts[1], parts[2]);
			memberTree.put(mediaMember.getMemberID(), mediaMember);
			text = br.readLine();
		}
		br.close();
	}

	/**
	 * Returns a list of all registered members
	 *
	 * @return List of members
	 **/
	@Override
	public List<Member> getMembers() {
		return memberTree.values();
	}

	/**
	 * Checks if the current user is in the the list of registered users
	 *
	 * @return true/false depending if the user exists
	 **/
	@Override
	public boolean userExists() throws NullPointerException {
		try {
			return memberTree.contains(currentUserID);
		} catch (Exception e) {
			throw new NullPointerException("Null pointer exception on finding member");
		}
	}

	/**
	 * Sets the current user to the input
	 *
	 * @param currentUser the user to be the current one
	 **/
	@Override
	public void setCurrentUserID(String currentUser) {
		this.currentUserID = currentUser;
	}


	/**
	 * Fetches a specified member through the use of their memberID
	 **/
	@Override
	public Member getCurrentUser() {
		return this.memberTree.get(currentUserID);
	}

}
