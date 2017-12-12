package ProblemDomain;

import java.io.File;
import java.io.Serializable;

class Birth implements Serializable{
	
	private int year;
	private int month;
	private int day;
	
	//���깆��
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
	
	
	@Override
	public String toString(){
		return year + "." + month + "." + day;
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
	private int gender;
	
	//���깆��
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
		gender = -1;
	}
	
	public User(String id, String passWord, String phoneNumber, String address, int year, int month, int day, String name, String schoolEmail, int gender, String introduction){
		this.id = id;
		this.passWord = passWord;
		this.phoneNumber = phoneNumber;
		this.address = address;
		Birth abirth = new Birth(year, month, day);
		this.birth = abirth;
		this.name = name;
		this.Fimage = null;
		this.check = true;//구현 x
		this.introduction = introduction;
		this.grade = 0;
		this.schoolEmail = schoolEmail;
		this.gender = gender;
	}
	//mypage ���명��湲�
	public void mypage(){
		
	}
	
	//��遺���湲�
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
	
	public void setGender(int gender){
		this.gender = gender;
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", passWord=" + passWord + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", birth=" + birth + ", name=" + name + ", Fimage=" + Fimage + ", check=" + check + ", introduction="
				+ introduction + ", grade=" + grade + ", schoolEmail=" + schoolEmail + ", gender=" + gender + "]";
	}
	public float getGrade(){
		return grade;
	}
	
	public String getSchoolEmail(){
		return schoolEmail;
	}
	
	public int getGender(){
		return gender;
	}
	
}
