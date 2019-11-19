package exClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuesList {
	public String listName;
	List<Questions> qtus;
	
	public QuesList(String listName)
	{
		this.listName = listName;
		this.qtus=new ArrayList<Questions>();
	}
	
	public void addQuestions(Questions qtu)
	{
		qtus.add(qtu);
	}
	
	public void removeQuestions(Questions qtu)
	{
		qtus.remove(qtu);
	}
	
	public Questions getQuestions(int i){//根据顺序获得题目对象
		return qtus.get(i);
	}
	
	public Questions getQuestions(String qno){//根据题目号获得题目对象
		Iterator<Questions> iter = qtus.iterator();
		while (iter.hasNext()) {
			Questions q = (Questions) iter.next();
			if(q.getQno().equals(qno)){
				return q;
			}
		}
		return null;
	}
	
	public static Questions randomQues(int num,QuesList quesList) { //根据取题范围和题库获得随机题目
		int ran1 =(int)(Math.random()*15);
		Questions ques=quesList.getQuestions(ran1);
		return ques;
	}
	
	public static int checkAns(Questions ques,String ans) { //根据题目示例（答案为默认权限，此类与答案处于一个包下）和学生答案进行对错判断
		if(ques.trueAnswer.equals(ans)) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	public int size(){
		return qtus.size();
	}
}
