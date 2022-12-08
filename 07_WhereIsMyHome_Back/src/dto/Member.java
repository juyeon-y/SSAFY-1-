package dto;

public class Member {
	private String userId, pwd, email;

	public Member(String userId, String pwd, String email) {
		super();
		setUserId(userId);
		setPwd(pwd);
		setEmail(email);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		if (userId != null) this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		if (pwd != null) this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null) this.email = email;
	}
	
}
