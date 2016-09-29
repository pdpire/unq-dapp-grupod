package model;

import java.util.ArrayList;

public class Place {

	private ArrayList<MusicalGenres> musicalGenres;
	private ArrayList<MoviesGenres> moviesGenres;
	private ArrayList<FoodStyle> foodStyles;
	private int cost;
	private int capacity;
	
	public Place( ArrayList<MusicalGenres> musicalGenres, ArrayList<MoviesGenres> moviesGenres, ArrayList<FoodStyle> foodStyles, int cost, int capacity) {
		this.capacity = capacity;
		this.foodStyles = foodStyles;
		this.moviesGenres = moviesGenres;
		this.musicalGenres = musicalGenres;
		this.cost = cost;
	}
	

	//-------------------------------getters and setters----------------------
	
	public ArrayList<MoviesGenres> getMoviesGenres() {
		return moviesGenres;
	}

	public void setMoviesGenres(ArrayList<MoviesGenres> moviesGenres) {
		this.moviesGenres = moviesGenres;
	}

	public ArrayList<FoodStyle> getFoodStyles() {
		return foodStyles;
	}

	public void setFoodStyles(ArrayList<FoodStyle> foodStyles) {
		this.foodStyles = foodStyles;
	}
	public ArrayList<MusicalGenres> getMusicalGenres() {
		return musicalGenres;
	}
	public void setMusicalGenres(ArrayList<MusicalGenres> musicalGenres) {
		this.musicalGenres = musicalGenres;
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