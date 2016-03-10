package playground.seb.uml.impl;

import collections.BinarySearchTree;
import collections.List;

/**
 * Interface for MemberService, places and controls members in a SearchTree
 * @author Sebastian Börebäck
 * @author Robin Johnsson
 */
public interface IMemberService {

    /**
     * Reads from file and places data in a BST
     * @param path filepath to file with members
     * @return Filled out memberTree, with all members added
     **/
    public BinarySearchTree<String, Member> loadMember(String path);

    /**
     * Returns a list of all registered members
     * @return List of members
     **/
    public List<Member> getMembers();

    /**
     * Fetches a specefied member through the use of their memberID
     * @param key the memberID of the member to be fetched
     **/
    public Member getMember(String key);

    /**
     * Sets the current user to the input
     * @param currentUser the user to be the current one
     **/
	void setCurrentUser(String currentUser);

    /**
     * Checks if the current user is in the the list of registered users
     * @return true/false depending if the user exists
     **/
    public boolean userExists();
}
