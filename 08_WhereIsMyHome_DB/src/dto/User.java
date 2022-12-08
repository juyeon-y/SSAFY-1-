package dto;

public class User {
	String email, name, password, nickname;

	public User(String email, String name, String password, String nickname) {
		super();
		setEmail(email);
		setName(name);
		setPassword(password);
		setNickname(nickname);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email!=null)
			this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name!=null)
			this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password!=null)
			this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		if(nickname!=null)
			this.nickname = nickname;
	}


	
	
}
