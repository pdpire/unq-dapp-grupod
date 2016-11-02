package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "musicalgenre")
@Entity
@Table(name="Musical_genre")
public class MusicalGenre extends model.Entity {
	
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
	
	public MusicalGenre(String nm){
		this.value = nm;
	}
	
	public MusicalGenre(){
		
	}
	
	
	public boolean compare(MusicalGenre mg){
		return this.getValue().equals(mg.getValue());
	}
}
