package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "profile")
public class Profile {
	
	private ArrayList<MusicalGenre> musicalGenres;
	private ArrayList<MovieGenre> moviesGenres;
	private ArrayList<FoodStyle> foodStyles;
	private Integer id;
	private int amountMax;
	

	public Profile(ArrayList<MusicalGenre> musicalGenres, ArrayList<MovieGenre> moviesGenres, ArrayList<FoodStyle> foodStyles, int amountMax) {
		this.setAmountMax(amountMax);
		this.setMusicalGenres(musicalGenres);
		this.setFoodStyles(foodStyles);
		this.setMoviesGenres(moviesGenres);
	}
	
	public boolean matchingProfiles(Event event) {
		boolean flag = false;
		if(event.getType().compare(new EventType("entertainment"))){
			for (MovieGenre moviesGenres : this.getMoviesGenres()) {
				flag = flag || this.getMoviesGenres().contains(moviesGenres);
			}
			for (MusicalGenre musicalGenres : this.getMusicalGenres()) {
				flag = flag || this.getMusicalGenres().contains(musicalGenres);
			}
		}
		if(event.getType().compare(new EventType("food"))){
			for (FoodStyle foodStyle : foodStyles) {
				flag = flag || this.getFoodStyles().contains(foodStyle);
			}
			
		}
		return flag;
	}

	
	
	
	
	//-------------------------------getters and setters----------------------


	public ArrayList<MusicalGenre> getMusicalGenres() {
		return musicalGenres;
	}

	public void setMusicalGenres(ArrayList<MusicalGenre> musicalGenres) {
		this.musicalGenres = musicalGenres;
	}


	public ArrayList<MovieGenre> getMoviesGenres() {
		return moviesGenres;
	}

	public void setMoviesGenres(ArrayList<MovieGenre> moviesGenres) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}