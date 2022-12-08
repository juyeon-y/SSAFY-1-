package member.dto;

public class Member {

	private String id, pw, name;

	public Member(String id, String pw) {
		super();
		setId(id);
		setPw(pw);
	}

	public Member(String id, String pw, String name) {
		super();
		setId(id);
		setPw(pw);
		setName(name);
	}

	public Member() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
        if (id != null) {
            this.id = id;
        } else {
            System.out.println("유효하지 않은 id입니다.");
        }
    }

	public String getPw() {
		return pw;
	}

	 public void setPw(String pw) {
	        if (id != null) {
	            this.pw = pw;
	        } else {
	            System.out.println("유효하지 않은 패스워드입니다.");
	        }

	    }

	public String getName() {
		return name;
	}

	 public void setName(String name) {
	        if (id != null) {
	            this.name = name;
	        } else {
	            System.out.println("유효하지 않은 이름입니다.");
	        }

	    }

}
