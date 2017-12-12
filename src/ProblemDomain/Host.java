package ProblemDomain;

import java.util.ArrayList;

public class Host {
	
	
	private ArrayList<Integer> postList;
	private ArrayList<Integer> clientList;
	
	public Host() {
		super();
		this.postList = new ArrayList<Integer>();
		this.clientList = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getPostList() {
		return postList;
	}
	
	public ArrayList<Integer> getCilentList() {
		return clientList;
	}


	
	public void setUserPostList(ArrayList<Integer> postList) {
		this.postList = postList;
	}
	
	public void setUserClientList(ArrayList<Integer> clientList) {
		this.clientList = clientList;
	}
	
	public void delPostList(int postIndex) {
		postList.remove(postIndex);
	}

	public void addPostList(int postIndex) {
		postList.add(postIndex);
	}
	
	public void delClientList(int postIndex) {
		clientList.remove(postIndex);
	}

	public void addClientList(int postIndex) {
		clientList.add(postIndex);
	}

}
