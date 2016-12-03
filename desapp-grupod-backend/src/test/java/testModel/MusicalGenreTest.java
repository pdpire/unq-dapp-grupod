package testModel;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import factory.MusicalGenreFactory;
import model.MusicalGenre;


public class MusicalGenreTest {

	
	@Test
	public void compareTest(){
		MusicalGenre musicalGenre = MusicalGenreFactory.anyMusicalGenre();
		MusicalGenre musicalGenreCompare = MusicalGenreFactory.anyMusicalGenre();
		
		assertTrue(musicalGenre.compare(musicalGenreCompare));
	}
}
