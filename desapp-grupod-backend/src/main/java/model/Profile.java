package model;

import java.util.ArrayList;

public class Profile {
	
	private ArrayList<MusicalGenres> musicalGenres;
	private ArrayList<MoviesGenres> moviesGenres;
	private ArrayList<FoodStyle> foodStyles;
	private int amountMax;
	


	public Profile(ArrayList<MusicalGenres> musicalGenres, ArrayList<MoviesGenres> moviesGenres, ArrayList<FoodStyle> foodStyles, int amountMax) {
		this.setAmountMax(amountMax);
		this.setMusicalGenres(musicalGenres);
		this.setFoodStyles(foodStyles);
		this.setMoviesGenres(moviesGenres);
	}
	
	public boolean matchingProfiles(Event event) {
		boolean flag = false;
		if(event.getType() == EventType.ENTERTAINMENT){
			for (MoviesGenres moviesGenres : this.getMoviesGenres()) {
				flag = flag || this.getMoviesGenres().contains(moviesGenres);
			}
			for (MusicalGenres musicalGenres : this.getMusicalGenres()) {
				flag = flag || this.getMusicalGenres().contains(musicalGenres);
			}
		}
		if(event.getType() == EventType.FOOD){
			for (FoodStyle foodStyle : foodStyles) {
				flag = flag || this.getFoodStyles().contains(foodStyle);
			}
			
		}
		return flag;
	}

	
	
	
	
	//-------------------------------getters and setters----------------------


	public ArrayList<MusicalGenres> getMusicalGenres() {
		return musicalGenres;
	}

	public void setMusicalGenres(ArrayList<MusicalGenres> musicalGenres) {
		this.musicalGenres = musicalGenres;
	}


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
	
	public int getAmountMax() {
		return amountMax;
	}
	public void setAmountMax(int amountMax) {
		this.amountMax = amountMax;
	}
}