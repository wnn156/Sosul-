package ProblemDomain;

import java.util.ArrayList;

public class Client extends User{
	
	
	private ArrayList<Integer> likeList;
	private ArrayList<Integer> rentList;
	
	public Client(){
		super();
		likeList = new ArrayList<Integer>();
		rentList = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getLikeList() {
		return likeList;
	}
	
	public ArrayList<Integer> getrentList() {
		return likeList;
	}



}
