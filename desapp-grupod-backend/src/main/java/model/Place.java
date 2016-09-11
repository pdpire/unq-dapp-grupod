package model;

import java.util.ArrayList;
import java.util.Date;

public class Place {

	private ArrayList<String> musicalGenres;
	private ArrayList<String> moviesGenres;
	private ArrayList<String> foodStyles;
	private int cost;
	private int capacity;
	
	
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
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
}
