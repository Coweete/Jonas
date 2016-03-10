package playground.seb.uml.impl;

import collections.BinarySearchTree;
import collections.List;

import java.io.IOException;

/**
 * Interface for MemberService, places and controls members in a SearchTree
 * @author Sebastian Börebäck
 * @author Robin Johnsson
 */
public interface IMemberService {

    /**
     * Reads from file and places data in a BST
     * @return Filled out memberTree, with all members added
     **/
    void loadMember() throws IOException;

    /**
     * Returns a list of all registered members
     * @return List of members
     **/
    List<Member> getMembers();

    /**
     * Sets the current user to the input
     * @param currentUser the user to be the current one
     **/
	void setCurrentUserID(String currentUser);

    /**
     * Checks if the current user is in the the list of registered users
     * @return true/false depending if the user exists
     **/
    boolean userExists() throws NullPointerException;

    /**
     * Fetches a specified member through the use of CurrentUserID
     **/
    public Member getCurrentUser();
}
