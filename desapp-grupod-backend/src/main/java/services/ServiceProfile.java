package services;

import model.Profile;
import persistence.ProfileRepository;

public class ServiceProfile extends GenericService<Profile> {
	
	private ProfileRepository profileRepository;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfileRepository getProfileRepository() {
		return profileRepository;
	}

	public void setProfileRepository(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

}
