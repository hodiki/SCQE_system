package exClass;

public class Student {
	String sno;
	String sname;
	String password;
	int sign;
	
	public Student(String sno,String sname,String password){
		this.sno=sno;
		this.sname=sname;
		this.password=password;
	}
	
	public void setSno(String sno){
		this.sno=sno;
	}
	
	public void setSname(String sname){
		this.sname=sname;
	}
	
	public String getSno(){
		return this.sno;
	}
	
	public String getSname(){
		return this.sname;
	}
	
	public int checkPassword(String password){
		if(this.password.equals(password)){
			return 1;
		}
		return 0;
		
	}
	
	public void signIn(){
		this.sign=1;
	}
	
	public void logout(){
		this.sign=0;
	}
	
	public int getSignState() {
		return this.sign;
	}
	
}
