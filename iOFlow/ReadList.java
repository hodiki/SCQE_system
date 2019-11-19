package iOFlow;

import java.io.IOException;

import exClass.*;


public class ReadList {
	String stuSrc;
	String quesSrc;
	StuList stus;
	QuesList qtus;
	public void startStu() throws IOException{
		readStu();
	}
	
	public void startQues() throws IOException{
		readQues();
	}
	
	void readStu() throws IOException{//����ѧ������
		String nameList;
		this.stus=new StuList("stuList");
		nameList=FileUtil.getFileContent(this.stuSrc);
		String[] stuList=nameList.split("\n");//��ȡ��ÿһ���ַ�
		String[] stuLine;
		
		//stus.addStudent(toolMan);
		for(int i=0;i<stuList.length;i++){
			stuLine=stuList[i].split(",");//�ٸ��ݡ������Ž��н���
			Student toolMan=new Student(stuLine[1],stuLine[2],stuLine[4]);
			stus.addStudent(toolMan);
		}
	}
	
	void readQues() throws IOException{//�������
		String nameList;
		this.qtus=new QuesList("quesList");
		nameList=FileUtil.getFileContent(this.quesSrc);
		String[] quesList=nameList.split("\n");//��ȡ��ÿһ���ַ�
		String[] quesLine;
		
		//stus.addStudent(toolMan);
		for(int i=0;i<quesList.length;i++){
			quesLine=quesList[i].split(",");//�ٸ��ݡ������Ž��н���
			Questions toolMan=new Questions(quesLine[0],quesLine[1],quesLine[2],quesLine[3],quesLine[4]);
			qtus.addQuestions(toolMan);
		}
	}
	
	
	public void setStuSrc(String src){//�����ļ�·����Ĭ��Ϊ��Ŀ��Ŀ¼��
		this.stuSrc=src;
	}
	
	public void setQuesSrc(String src){
		this.quesSrc=src;
	}
	
	public StuList getStuList(){//��ȡ����
		return this.stus;
	}
	
	public QuesList getQuesList(){//��ȡ����
		return this.qtus;
	}
}
