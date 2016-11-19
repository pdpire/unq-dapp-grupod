package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EventType")
public class EventType extends model.Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "value")
	private String value;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public EventType(String nm){
		this.value = nm;
	}
	
	public boolean compare(EventType et){
		return this.getValue().equals(et.getValue());
	}

}
