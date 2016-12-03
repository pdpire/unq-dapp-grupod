package factory;

import model.MusicalGenre;

public class MusicalGenreFactory {
	
	public static MusicalGenre anyMusicalGenre(){
		
		MusicalGenre mg = new MusicalGenre("value");
		
		return mg;
	}

}
