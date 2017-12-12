package ProblemDomain;



import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



class Price{
	private boolean trustcost;
	private float cost;
	private float supoort;
}



public class Room implements Serializable{
	private File Fimage;
	private byte[] Iimage;
	private String opt;
	private int stair;
	private int sound;
	private float size;
	private int window;
	private int clean;
	private Price price;
	private String introduce; 
	private String period;
	

	public Room(){
		this.Fimage=null;
		this.Iimage=null;
		this.opt= null;
		this.stair=0;
		this.sound=0;
		this.size=0;
		this.window=0;
		this.clean=0;
		this.price=new Price();
		this.introduce=null;
		this.period=null;
		
		}
	
	public Room(String opt,int stair,int sound, int size, int window,int clean, Price price, String introduce, String period){
		
	}
	
	
	public void setOpt(String opt) {
		this.opt = opt;
	}
	
	public String getOpt() {
		return opt;
	}
	
	public void setStair(int stair) {
		this.stair=stair;
	}
	
	public int getStair() {
		return stair;
	}
	
	public void setSound(int sound) {
		this.sound = sound;
	}
	
	public int getSound() {
		return sound;
	}
	
	public void setSize(int size) {
		this.size=size;
	}
	
	public float getSize() {
		return size;
	}
	
	public void setWindow(int window) {
		this.window=window;
	}
	
	public int getWindow() {
		return window;
	}
	public void setClean(int clean) {
		this.clean=clean;
	}
	
	public int getclean() {
		return clean;
	}

	
	public void setOption(Price price)
	{
		this.price= new Price();
	}
	public Price getprice(){
		return price;
	}
	
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String getIntroduce() {
		return introduce;
	}
	
	
	public void setPeriod(String period) {
		this.period=period;
	}
	
	public String getPeriod() {
		return period;
	}
	
	
}
	
	



