package playground.seb.uml.impl;
import collections.ArrayList;

/**
 * This class creates a member-object that contains a name, id and phonenumber.
 * Each member is also assigned a unique loan-list that keeps track of all their loans.
 *
 * Created by Johnatan Sona on 2016-03-09.
 */
public class Member {
	private ArrayList<Media> loan;
	private String memberID;
	private String name;
	private String phoneNumber;

	/**
	 * This constructor creates the member-object with a set name, id and phone-number.
	 * It also creates a new ArrayList of loans for the member.
	 *
	 * @param memberID The identification of the member
	 * @param name	The name of the member
	 * @param phoneNumber The phone-number of the member
	 */
	public Member(String memberID, String name, String phoneNumber){
		this.memberID = memberID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		loan = new ArrayList<>();

	}

	/**
	 * Used to get the loan-list of a member.
	 *
	 * @return returns the loan-list
	 */
	public ArrayList<Media> getLoan() {
		return loan;
	}

	/**
	 * Used to get the member-id of a member.
	 *
	 * @return returns the member-id
	 */
	public String getMemberID() {
		return memberID;
	}

	/**
	 * Used to get the name of a member.
	 *
	 * @return returns the members name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Used to get the phone-number of a member.
	 *
	 * @return returns the members phone-number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This method adds a new Media-item to the members loan-list.
	 *
	 * @param mediaItem The Media-item that is to be added
	 */
	public void loanMedia(Media mediaItem){
		loan.add(mediaItem);
	}

	/**
	 * This Method removes a Media-object from the members loan-list.
	 * It returns true if the item exists in the list and can be remove. Otherwise it returns false.
	 *
	 * @param mediaItem The Media-item that is to be removed
	 * @return	returns true of false
	 */
	public boolean returnMedia(Media mediaItem){
		return loan.remove(loan.indexOf(mediaItem)) != null;
	}

}
