package model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "foodstyle")
public class FoodStyle {
	
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
	public void setValue(String name) {
		this.value = name;
	}
	
	public FoodStyle(String nm){
		this.value = nm;
	}
	
	public boolean compare(FoodStyle foodStyle){
		return this.getValue().equals(foodStyle.getValue());
	}
}
