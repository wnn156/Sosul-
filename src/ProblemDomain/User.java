package ProblemDomain;

import java.io.File;
import java.io.Serializable;

class Birth implements Serializable{
	
	private int year;
	private int month;
	private int day;
	
	//생성자
	public Birth(){
		year = 0;
		month = 0;
		day = 0;
	}
	
	public Birth(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	//set method
	public void setYear(int year){
		this.year = year;
	}
	
	public void setMonth(int month){
		this.month = month;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	//get method
	public int getYear(){
		return year;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
}

public class User implements Serializable {

	private String id;
	private String passWord;
	private String phoneNumber;
	private String address;
	private Birth birth;
	private String name;
	private File Fimage;
	private boolean check;
	private String introduction;
	private float grade;
	private String schoolEmail;
	
	//생성자
	public User(){
		id = null;
		passWord = null;
		phoneNumber = null;
		address = null;
		birth = new Birth();
		name = null;
		Fimage = null;
		check = false;
		introduction = null;
		grade = 0;
		schoolEmail = null;
	}
	public User(String id, String passWord){
		this.id = id;
		this.passWord = passWord;
		phoneNumber = null;
		address = null;
		birth = new Birth();
		name = null;
		Fimage = null;
		check = false;
		introduction = null;
		grade = 0;
		schoolEmail = null;
	}
	public User(String id, String passWord, String phoneNumber, String address, Birth birth, String name, File Fimage, boolean check, String introduction, float grade, String schoolEmail){
		this.id = id;
		this.passWord = passWord;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.birth = birth;
		this.name = name;
		this.Fimage = Fimage;
		this.check = check;
		this.introduction = introduction;
		this.grade = grade;
		this.schoolEmail = schoolEmail;
	}
	//mypage 확인하기
	public void mypage(){
		
	}
	
	//환불하기
	public void refund(){
		
	}
		
	//set method
	public void setId(String id){
		this.id = id;
	}
	
	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setBirth(Birth birth){
		this.birth = birth;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setFimage(File Fimage){
		this.Fimage = Fimage;
	}
	
	public void setCheck(boolean check){
		this.check = check;
	}
	
	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}
	
	public void setGrade(float grade){
		this.grade = grade;
	}
	
	public void setSchoolEmail(String schoolEmail){
		this.schoolEmail = schoolEmail;
	}
	
	//get method
	public String getId(){
		return id;
	}
	
	public String getPassWord(){
		return passWord;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getAddress(){
		return address;
	}
	
	public Birth getBirth(){
		return birth;
	}
	
	public String getName(){
		return name;
	}
	
	public File getFimage(){
		return Fimage;
	}
	
	public boolean getCheck(){
		return check;
	}
	
	public String getIntroduction(){
		return introduction;
	}
	
	public float getGrade(){
		return grade;
	}
	
	public String getSchoolEmail(){
		return schoolEmail;
	}
	

}
