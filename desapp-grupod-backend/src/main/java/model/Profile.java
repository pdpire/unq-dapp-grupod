package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.*;




//@XmlRootElement(name = "profile")
@Entity
@Table(name="Profile")
public class Profile extends model.Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_profile_musicalGenres")
	private Set<MusicalGenre> musicalGenres = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_profile_moviesGenres")
	private Set<MovieGenre> moviesGenres = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinColumn(name = "id_profile_foodStyles")
	private Set<FoodStyle> foodStyles = new HashSet<>();
	
	@Column(name = "amountMax")
	private int amountMax;
	
	@Column(name = "nameUser")
	private String nameUser;
	
	@Column(name = "email")
	private String email;
	
	public Profile(){
	}

	public Profile(Set<MusicalGenre> musicalGenres, Set<MovieGenre> moviesGenres, Set<FoodStyle> foodStyles, String name ,int amountMax , String email) {
		this.amountMax = amountMax;
		this.musicalGenres = musicalGenres;
		this.foodStyles = foodStyles;
		this.moviesGenres = moviesGenres;
		this.nameUser = name;
		this.email = email;
	}
	
	public boolean matchingProfiles(Event event) {
		boolean flag = false;
		if(event.getType().compare("entertainment")){
			for (MovieGenre moviesGenres : this.getMoviesGenres()) {
				flag = flag || this.getMoviesGenres().contains(moviesGenres);
			}
			for (MusicalGenre musicalGenres : this.getMusicalGenres()) {
				flag = flag || this.getMusicalGenres().contains(musicalGenres);
			}
		}
		if(event.getType().compare("food")){
			for (FoodStyle foodStyle : foodStyles) {
				flag = flag || this.getFoodStyles().contains(foodStyle);
			}
			
		}
		return flag;
	}
	
	//-------------------------------getters and setters----------------------
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public Set<MusicalGenre> getMusicalGenres() {
		return musicalGenres;
	}

	public void setMusicalGenres(Set<MusicalGenre> musicalGenres) {
		this.musicalGenres = musicalGenres;
	}


	public Set<MovieGenre> getMoviesGenres() {
		return moviesGenres;
	}

	public void setMoviesGenres(Set<MovieGenre> moviesGenres) {
		this.moviesGenres = moviesGenres;
	}
	
	public int getAmountMax() {
		return amountMax;
	}
	public void setAmountMax(int amountMax) {
		this.amountMax = amountMax;
	}

	public Set<FoodStyle> getFoodStyles() {
		return foodStyles;
	}

	public void setFoodStyles(Set<FoodStyle> foodStyles) {
		this.foodStyles = foodStyles;
	}

}