package ProblemDomain;

import java.io.Serializable;

class Condition implements Serializable{
	
	private boolean gender;
	private boolean smoke;
	private boolean animal;
	private boolean exitArrangement;
	private boolean clean;
	
	public Condition(){
		gender = false;
		smoke = false;
		animal = false;
		exitArrangement = false;
		clean = false;
	}
	
	public Condition(boolean gender, boolean smoke, boolean animal, boolean exitArrangement, boolean clean){
		this.gender = gender;
		this.smoke = smoke;
		this.animal = animal;
		this.exitArrangement = exitArrangement;
		this.clean = clean;
	}
	
	public void setGender(boolean gender){
		this.gender = gender;
	}
	
	public boolean getGender(){
		return this.gender;
	}
	
	public void setSmoke(boolean smoke){
		this.smoke = smoke;
	}
	
	public boolean getSmoke(){
		return this.smoke;
	}
	
	public void setAnimal(boolean animal){
		this.animal = animal;
	}
	
	public boolean getAnimal(){
		return this.animal;
	}
	
	public void setExitArrangement(boolean exitArrangement){
		this.exitArrangement = exitArrangement;
	}
	
	public boolean getExitArrangement(){
		return this.exitArrangement;
	}
	
	public void setClean(boolean clean){
		this.clean = clean;
	}
	
	public boolean getClean(){
		return this.clean;
	}
	
}

public class Post implements Serializable {
	private int index;
	private String title;
	private Condition condition;
	private String state;
	private boolean isView;
	private Room room;
	private String review;
	
	public Post(){
		index = 0;
		title = null;
		condition = new Condition();
		state = null;
		isView = false;
		review = null;
		room = new Room();
	}
	public Post(int index, String title,float size){
		this.index = index;
		this.title = title;
		condition = new Condition();
		state = null;
		isView = false;
		review = null;
		room = new Room();
		room.setSize(size);
	}
	@Override
	public String toString() {
		return "Post [index=" + index + ", title=" + title + ", condition=" + condition + ", state=" + state
				+ ", isView=" + isView + ", room=" + room + ", review=" + review + "]";
	}
	public Post(int index,String title,boolean gender, boolean smoke, boolean animal, boolean exitArrangement, boolean clean, String state, boolean isView, Room room, String review){
		this.index = index;
		this.title = title;
		this.condition = new Condition(gender,smoke,animal,exitArrangement,clean);
		this.state = state;
		this.isView = isView;
		this.room = room;
		this.review = review;
		
	}
	
	public void checkPostingCondition(){
		
	}
	
	public void setIndex(int index){
		this.index = index;
	}
	public int getIndex(){
		return this.index;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}
	public void setCondition(Condition condition){
		this.condition = condition;
	}
	public Condition getCondition(){
		return this.condition;
	}
	
	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return this.state;
	}
	
	public void setIsView(boolean isView){
		this.isView = isView;
	}
	public boolean getIsView(){
		return this.isView;
	}

	public void setRoom(Room room){
		this.room = room;
	}
	public Room getRoom(){
		return this.room;
	}
	public void setReview(String review){
		this.review = review;
	}
	public String getReview(){
		return this.review;
	}
}
