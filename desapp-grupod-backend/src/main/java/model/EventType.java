package model;

public class EventType {
	
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
	
	public EventType(String nm){
		this.value = nm;
	}
	
	public boolean compare(EventType et){
		return this.getValue().equals(et.getValue());
	}

}
