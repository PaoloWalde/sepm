package user;

public class Assistant
{
	private String name;
	private String id;
	private String email;
	private String phoneNumber;
	private String password;
	
	public Assistant (String name, String id, String email, String phoneNumber) {
		this.id = name;
		this.name = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String toString() {
		return "Assistant: \n\tname:  " + name + "\n\tid:  " + id + "\n\temail:  " + email + "\n\tPhone No.:  " + phoneNumber;
	}
}
