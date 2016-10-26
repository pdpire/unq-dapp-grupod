package model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "profile")
public class Profile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MusicalGenre> musicalGenres;
	private List<MovieGenre> moviesGenres;
	private List<FoodStyle> foodStyles;
	private Integer id;
	private int amountMax;
	

	public Profile(List<MusicalGenre> musicalGenres, List<MovieGenre> moviesGenres, List<FoodStyle> foodStyles, int amountMax) {
		this.amountMax = amountMax;
		this.musicalGenres = musicalGenres;
		this.foodStyles = foodStyles;
		this.moviesGenres = moviesGenres;
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

	public List<MusicalGenre> getMusicalGenres() {
		return musicalGenres;
	}

	public void setMusicalGenres(List<MusicalGenre> musicalGenres) {
		this.musicalGenres = musicalGenres;
	}


	public List<MovieGenre> getMoviesGenres() {
		return moviesGenres;
	}

	public void setMoviesGenres(List<MovieGenre> moviesGenres) {
		this.moviesGenres = moviesGenres;
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
	
	public List<FoodStyle> getFoodStyles() {
		return foodStyles;
	}

	public void setFoodStyles(List<FoodStyle> foodStyles) {
		this.foodStyles = foodStyles;
	}

}