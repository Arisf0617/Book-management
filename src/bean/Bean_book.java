package bean;

public class Bean_book {
    private int id;
    private String name;
    private String writer;
    private String press;
    private int num;

    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	public Bean_book(int id, String name, String writer,  String press,int num) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.press = press;
        this.num = num;
    }
	
	
	
	public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", press='" + press + '\'' +
                ", num=" + num +
                '}';
    }


}
