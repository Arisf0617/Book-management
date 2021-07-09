package bean;

public class Bean_user {
	
    private int uid;
    private String name;
    private String sex;
    private String college;
    private String password;
    private String identity;

    
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	public Bean_user(int uid, String name, String sex,  String college,String password,String identity) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
        this.college = college;
        this.password = password;
        this.identity = identity;
    }
	
	
	
	
	public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", college='" + college + '\'' +
                ", password='" + password + '\'' +
                ", identity=" + identity +
                '}';
    }

}
