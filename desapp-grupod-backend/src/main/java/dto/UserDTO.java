package dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.User;

public class UserDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6989470341398605887L;

	
	private String name;
	private String email;
	private String password;
	private int idprofile;

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getIdprofile() {
		return idprofile;
	}


	public void setIdprofile(int idprofile) {
		this.idprofile = idprofile;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public UserDTO copyData(User user){
		
		name = user.getName();
		email = user.getEmail();
		password = user.getPassword();
		
		if(user.getProfile() != null)
			setIdprofile(user.getProfile().getId());
		
		return this;

	}
	
	
	public Set<UserDTO> copyOnList(List<User> listUsers){
		
		Set<UserDTO> listDto = new HashSet<UserDTO>();
		
		for (User user : listUsers) {
			listDto.add(new UserDTO().copyData(user));
		}
		
		return listDto;
	}


}
