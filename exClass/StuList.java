package exClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StuList {
	public String listName;
	List<Student> stus;
	
	public StuList(String listName)
	{
		this.listName = listName;
		this.stus=new ArrayList<Student>();
	}
	
	public StuList(String clazzName,String lines)
	{
		
	}
	
	
	public void addStudent(Student stu)
	{
		stus.add(stu);
	}
	
	public void removeStudent(Student stu)
	{
		stus.remove(stu);
	}
	
	public Student getStudent(int i){//根据顺序获得学生对象
		return stus.get(i);
	}
	
	public Student getStudent(String sno){//根据学号获得学生对象
		Iterator<Student> iter = stus.iterator();
		while (iter.hasNext()) {
			Student s = (Student) iter.next();
			if(s.getSno().equals(sno)){
				return s;
			}
		}
		return null;
	}
	
	
	
	public int size(){
		return stus.size();
	}
	
}
