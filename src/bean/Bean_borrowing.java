package bean;


public class Bean_borrowing {
    private int id;
    private String name;
    private String writer;
    private String press;
    private String date;
    private int borrower;



    
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
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBorrower() {
		return borrower;
	}
	public void setBorrower(int borrower) {
		this.borrower = borrower;
	}
	
	public Bean_borrowing(int id, String name, String writer,  String press,String date,int borrower) {
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.press = press;
        this.date = date;
        this.borrower=borrower;
    }
	
	public String toString() {
        return "Borrowing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", press='" + press + '\'' +
                ", date='" + date + '\'' +
                ", borrower=" + borrower +
                '}';
    }

}
