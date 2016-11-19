package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


//@XmlRootElement(name = "foodstyle")
@Entity
@Table(name="Food_style")
public class FoodStyle extends model.Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "value")
	private String value;

	public String getValue() {
		return value;
	}
	public void setValue(String name) {
		this.value = name;
	}
	
	public FoodStyle(String nm){
		this.value = nm;
	}
	
	public FoodStyle(){
	} 
	
	public boolean compare(FoodStyle foodStyle){
		return this.getValue().equals(foodStyle.getValue());
	}
}
