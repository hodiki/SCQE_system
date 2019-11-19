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
	
	public Questions getQuestions(int i){//����˳������Ŀ����
		return qtus.get(i);
	}
	
	public Questions getQuestions(String qno){//������Ŀ�Ż����Ŀ����
		Iterator<Questions> iter = qtus.iterator();
		while (iter.hasNext()) {
			Questions q = (Questions) iter.next();
			if(q.getQno().equals(qno)){
				return q;
			}
		}
		return null;
	}
	
	public static Questions randomQues(int num,QuesList quesList) { //����ȡ�ⷶΧ������������Ŀ
		int ran1 =(int)(Math.random()*15);
		Questions ques=quesList.getQuestions(ran1);
		return ques;
	}
	
	public static int checkAns(Questions ques,String ans) { //������Ŀʾ������ΪĬ��Ȩ�ޣ�������𰸴���һ�����£���ѧ���𰸽��жԴ��ж�
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
