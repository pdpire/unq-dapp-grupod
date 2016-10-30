package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "moviegenre")
public class MovieGenre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public MovieGenre(String nm){
		this.value = nm;
	}
	public MovieGenre(){
	}
	
	public boolean compare(MovieGenre mg){
		return this.getValue().equals(mg.getValue());
	}

}
