package factory;

import java.util.HashSet;
import java.util.Set;

import model.FoodStyle;
import model.MovieGenre;
import model.MusicalGenre;
import model.Profile;
import model.User;

public class ProfileFactory {

	public static Profile profileWithFoodStyles(){
		
		
		FoodStyle fs1 = new FoodStyle("vegentarian");
		FoodStyle fs2 = new FoodStyle("pizza");
		
		Set<FoodStyle> setFS = new HashSet<>();
		setFS.add(fs1);
		setFS.add(fs2);
		
		Profile profile = new Profile(null, null, setFS, null, 0, null);
		
		return profile;
	}
	
	public static Profile profileWithMoviesAndMusical(){
		
		
		MovieGenre mog1 = new MovieGenre("terror");
		MovieGenre mog2 = new MovieGenre("action");
		
		Set<MovieGenre> setMog = new HashSet<>();
		setMog.add(mog1);
		setMog.add(mog2);
		
		MusicalGenre mug1 = new MusicalGenre("rock");
		MusicalGenre mug2 = new MusicalGenre("pop");
		
		Set<MusicalGenre> setMug = new HashSet<>();
		setMug.add(mug1);
		setMug.add(mug2);
		
		
		Profile profile = new Profile(setMug, setMog, null, null, 0, null);
		
		return profile;
	}

}
