package model;

public class MusicalGenre {
	
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
	
	public MusicalGenre(String nm){
		this.value = nm;
	}
	
	public MusicalGenre(){
		
	}
	
	
	public boolean compare(MusicalGenre mg){
		return this.getValue().equals(mg.getValue());
	}
}
