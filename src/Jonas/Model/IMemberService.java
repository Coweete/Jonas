package Jonas.Model;

import collections.List;

import java.io.IOException;

/**
 * Interface for MemberService, places and controls members in a SearchTree
 * @author Sebastian Börebäck
 * @author Robin Johnsson
 */
public interface IMemberService {

    /**
     * Calls the private method "loadMember(String path)"
     * Reads from file and places data in a BST
     * @throws NullPointerException when files is not found
     * @throws IOException when files is not found
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
     * @throws NullPointerException when file is not found
     **/
    boolean userExists() throws NullPointerException;

    /**
     *
     * Fetches a specified member through the use of CurrentUserID
     * @return the Current Member object
     **/
    public Member getCurrentUser();

}
