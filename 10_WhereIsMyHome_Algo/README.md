SSAFY Algorithm 관통 프로젝트 \<WhereIsMyHome>
======

### 페어
  양주연, 박윤환, 남이랑
  
### 개발 기간
  2022.10.12
  
### 개요
WhereIsMyHome 프로젝트에 알고리즘을 적용한다

### 요구사항
1. 기존 WhereIsMyHome 프로젝트 구현시 알고리즘이 필요한 곳을 찾고, 알맞은 알고리즘을 구현하여 추가한다
2. 알고리즘은 2개이상 적용한다
   - SHA256
   - AES128


## 클래스 다이어그램


![ERD](https://user-images.githubusercontent.com/47595515/195261903-b4dc7b79-0b32-4346-9591-0c44e4fdf73a.png)

| SQL파일 | [schema.sql](./WebContent/resources/schema.sql) |
|-------|-------------------------------------------------|



주요 코드
=============

| 구현내용              | 코드                                                            |
|-------------------|---------------------------------------------------------------|
| 메인페이지 html        | [index.html](./WebContent/index.html)                         |
| 회원가입 html         | [memberInsert.html](./WebContent/member/memberInsert.html)    |
| html에 각종 이벤트 구현   | [my.js](./WebContent/js/my.js)                                |
| 회원가입, 로그인에 암호화 적용 | [MemberService.java](./src/member/service/MemberService.java) |
| DB와 연동            | [MemberDao.java](./src/member/dao/MemberDao.java)             |



<br>


# 회원정보를 테이블에 암호화해서 저장
## 회원가입
<img src="https://user-images.githubusercontent.com/47595515/195263732-060f69b4-53be-46a4-9207-a66fa40f599b.png" width="400"/>

## 테이블에 저장된 내용
### member 테이블
패스워드 : SHA256 적용
이름 : AES128 적용
![member table](https://user-images.githubusercontent.com/47595515/195262826-2889fdb8-3c77-4fef-9bd4-d43df7a8a8ab.png)

### security 테이블
SHA256에 사용할 개인별 salt와 AES키 저장
![security table](https://user-images.githubusercontent.com/47595515/195262857-d71b6f9e-78ed-4a0b-9785-1c0119050d58.png)

## 로그인
### 로그인 후 표시되는 이름
DB에 저장된 암호화된 이름을 복호화 하여 표시  
<img src="https://user-images.githubusercontent.com/47595515/195265566-172d61e2-b244-43bf-877d-36706a0c194d.png" width="256"/>

# 제출 소스
## 회원가입시 암호화 적용
### MemberService.java (line 41 ~ 59)
``` java
public int memberInsert(Member member) {
		if ( memberDao.memberSelect(member.getId()) != null ) {
			return -1; //중복인 아이디 존재
		} else {
			try {
			   byte[] key=OpenCrypt.generateKey("AES",128);
			   System.out.println("key length:"+key.length);
			   SecVO sec=new SecVO(member.getId(),UUID.randomUUID().toString(),OpenCrypt.byteArrayToHex(key));
			   int cnt = memberDao.securityInsert(sec);
			   if(cnt<=0) return -1; //security 테이블 insert 실패
			   member.setName(OpenCrypt.aesEncrypt(member.getName(), key));
			   member.setPw(OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(member.getPw(), sec.getSalt())));
			   return memberDao.memberInsert(member); //회원가입 성공
			} catch(Exception e ){
			  e.printStackTrace();
				   return -1; //sql 에러났을 때
			}
		}
	}
```
### MemberDao.java (line 43 ~ 85)
```java
public int memberInsert(Member member) {
		String sql = "insert into member(id, pw, name) values(?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPw());
			stmt.setString(3, member.getName());
			
			return stmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Member memberSelect(String id) {
		String sql = "select * from member where id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Member(id, rs.getString("pw"), rs.getString("name"));
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int securityInsert(SecVO sec) {
		String sql = "insert into security( id, salt, seckey) values(?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, sec.getUserId());
			stmt.setString(2, sec.getSalt());
			stmt.setString(3, sec.getSecKey());
			return stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
```

## 로그인시 이름 복호화 및 해싱된 암호 이용
### MemberService.java (line 20 ~ 39)
```java
public Member login(String id, String pw) {
		SecVO sec = memberDao.selectSecurity(id);
		if(sec != null) {
			pw = OpenCrypt.byteArrayToHex(OpenCrypt.getSHA256(pw, sec.getSalt()));
			Member m = memberDao.login(id, pw);
			if (m != null) {
				try {
					m.setName(OpenCrypt.aesDecrypt(m.getName(), OpenCrypt.hexToByteArray(sec.getSecKey())));
					return m;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
```

### MemberDao.java
(line 27 ~ 41)
```java
public Member login(String id, String pw) {
		String sql = "select * from member where id=? and pw=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {					
				return new Member(id, pw, rs.getString("name"));
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
```
(line 87 ~ 100) 
```java
public SecVO selectSecurity(String id) {
		String sql = "select salt, seckey from security where id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new SecVO(id, rs.getString("salt"), rs.getString("seckey"));
			}
			return null;
 		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
```
