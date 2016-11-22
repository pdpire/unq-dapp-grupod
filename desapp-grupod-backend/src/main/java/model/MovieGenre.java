package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Movie_genre")
public class MovieGenre extends model.Entity{
	
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
	
	public MovieGenre(String nm){
		this.value = nm;
	}
	public MovieGenre(){
	}
	
	public boolean compare(MovieGenre mg){
		return this.getValue().equals(mg.getValue());
	}

}
