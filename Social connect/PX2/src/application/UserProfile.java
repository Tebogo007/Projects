/**
 * 
 */
package application;

/**
 * @author TM Mampa 219110597
 *
 */
public class UserProfile implements Comparable<UserProfile>{
	
	//variables needed
	private String username;
	private String password;
	private String about;
	private String Hobbies;
	
	/**
	 * 
	 * @param user
	 * @param password
	 * @param about
	 * @param Hobbies
	 */
	public UserProfile(String user, String password, String about, String Hobbies)
	{
		this.username = user;
		this.password = password;
		this.about = about;
		this.Hobbies = Hobbies;
	}
	
	/**
	 * getter for username
	 * @return username
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * getter for password
	 * @return password
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * setting the username
	 * @param user
	 */
	public void setUsername(String user)
	{
		this.username = user;
	}
	
	/**
	 * setting the password
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public int compareTo(UserProfile o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * getter for Bio
	 * @return about
	 */
	public String getAbout() {
		return about;
	}
	
	/**
	 * setting the about
	 * @param about
	 */
	public void setAbout(String about) {
		this.about = about;
	}
	
	/**
	 * getter for hobbies
	 * @return hobbies
	 */
	public String getHobbies() {
		return Hobbies;
	}
	
	/**
	 * setting the hobbies
	 * @param hobbies
	 */
	public void setHobbies(String hobbies) {
		Hobbies = hobbies;
	}

}
