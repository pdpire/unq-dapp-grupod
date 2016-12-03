package factory;

import model.MovieGenre;

public class MovieGenreFactory {
	
	public static MovieGenre anyMovieGenre(){
		
		MovieGenre mg = new MovieGenre("value");
		
		return mg;
	}

}
