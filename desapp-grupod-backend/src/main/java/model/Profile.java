package model;

import java.util.ArrayList;

public class Profile {
	
	private ArrayList<String> musicalGenres;
	private ArrayList<String> moviesGenres;
	private ArrayList<String> foodStyles;
	private ArrayList<String> transport;
	private int amountMax;
	
	
	//-------------------------------getters and setters----------------------
	public ArrayList<String> getMusicalGenres() {
		return musicalGenres;
	}
	public void setMusicalGenres(ArrayList<String> musicalGenres) {
		this.musicalGenres = musicalGenres;
	}
	public ArrayList<String> getMoviesGenres() {
		return moviesGenres;
	}
	public void setMoviesGenres(ArrayList<String> moviesGenres) {
		this.moviesGenres = moviesGenres;
	}
	public ArrayList<String> getFoodStyles() {
		return foodStyles;
	}
	public void setFoodStyles(ArrayList<String> foodStyles) {
		this.foodStyles = foodStyles;
	}
	public ArrayList<String> getTransport() {
		return transport;
	}
	public void setTransport(ArrayList<String> transport) {
		this.transport = transport;
	}
	public int getAmountMax() {
		return amountMax;
	}
	public void setAmountMax(int amountMax) {
		this.amountMax = amountMax;
	}

}
