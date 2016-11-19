package model;

@SuppressWarnings("serial")
public class NoFoundTypeEventException extends Exception {
	
	public NoFoundTypeEventException(){
		super("Any event found");
	}

}
