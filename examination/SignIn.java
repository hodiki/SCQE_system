package examination;

import exClass.Student;
import iOFlow.ReadList;

public class SignIn {
//	public int SignIN(){
//		
//		return 0;
//	}
	ReadList stuList;
	public int sIn(ReadList stuList,String sno,String password){
		int sin=0;
		if(check(stuList,sno,password)==1){
			sin=1;
		}else{
			sin=0;
		}
		return sin;
	}
	
	private int check(ReadList stuList,String sno,String password){
		
		Student stu1=stuList.getStuList().getStudent(sno);
		if(stu1.checkPassword(password)==1){
			return 1;
		}
		return 0;
	}
}
