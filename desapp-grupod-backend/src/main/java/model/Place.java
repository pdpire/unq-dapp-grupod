package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="Place")
public class Place extends model.Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_place_musicalGenres")
	private Set<MusicalGenre> musicalGenres = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_place_moviesGenres")
	private Set<MovieGenre> moviesGenres = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_place_foodStyles")
	private Set<FoodStyle> foodStyles = new HashSet<>();
	
	@Column(name = "cost")
	private int cost;
	
	@Column(name = "capacity")
	private int capacity;
	
	
	public Place( Set<MusicalGenre> musicalGenres, Set<MovieGenre> moviesGenres, Set<FoodStyle> foodStyles, int cost, int capacity) {
		this.capacity = capacity;
		this.foodStyles = foodStyles;
		this.moviesGenres = moviesGenres;
		this.musicalGenres = musicalGenres;
		this.cost = cost;
	}
	

	//-------------------------------getters and setters----------------------
	
	public Set<MovieGenre> getMoviesGenres() {
		return moviesGenres;
	}

	public void setMoviesGenres(Set<MovieGenre> moviesGenres) {
		this.moviesGenres = moviesGenres;
	}

	public Set<FoodStyle> getFoodStyles() {
		return foodStyles;
	}

	public void setFoodStyles(Set<FoodStyle> foodStyles) {
		this.foodStyles = foodStyles;
	}
	public Set<MusicalGenre> getMusicalGenres() {
		return musicalGenres;
	}
	public void setMusicalGenres(Set<MusicalGenre> musicalGenres) {
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