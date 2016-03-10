package playground.seb.uml.impl;
import collections.ArrayList;

/**
 * Created by Johnatan Sona on 2016-03-09.
 */
public class Member {
	private ArrayList<Media> loan;
	private String memberID;
	private String name;
	private String phoneNumber;

	public Member(String memberID, String name, String phoneNumber){
		this.memberID = memberID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		loan = new ArrayList<>();

	}

	public ArrayList getLoan() {
		return loan;
	}

	public String getMemberID() {
		return memberID;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void loanMedia(Media mediaItem){
		loan.add(mediaItem);
	}

	public boolean returnMedia(Media mediaItem){
		return loan.remove(loan.indexOf(mediaItem)) != null;
	}

}
