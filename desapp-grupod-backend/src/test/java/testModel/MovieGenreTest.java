package testModel;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import factory.MovieGenreFactory;
import model.MovieGenre;

public class MovieGenreTest {
	
	@Test
	public void compareTest(){
		MovieGenre movieGenre = MovieGenreFactory.anyMovieGenre();
		MovieGenre movieGenreCompare = MovieGenreFactory.anyMovieGenre();
		
		assertTrue(movieGenre.compare(movieGenreCompare));
	}


}
