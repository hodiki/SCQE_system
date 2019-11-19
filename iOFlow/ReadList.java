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
	
	void readStu() throws IOException{//解析学生名单
		String nameList;
		this.stus=new StuList("stuList");
		nameList=FileUtil.getFileContent(this.stuSrc);
		String[] stuList=nameList.split("\n");//先取出每一行字符
		String[] stuLine;
		
		//stus.addStudent(toolMan);
		for(int i=0;i<stuList.length;i++){
			stuLine=stuList[i].split(",");//再根据“，”号进行解析
			Student toolMan=new Student(stuLine[1],stuLine[2],stuLine[4]);
			stus.addStudent(toolMan);
		}
	}
	
	void readQues() throws IOException{//解析题库
		String nameList;
		this.qtus=new QuesList("quesList");
		nameList=FileUtil.getFileContent(this.quesSrc);
		String[] quesList=nameList.split("\n");//先取出每一行字符
		String[] quesLine;
		
		//stus.addStudent(toolMan);
		for(int i=0;i<quesList.length;i++){
			quesLine=quesList[i].split(",");//再根据“，”号进行解析
			Questions toolMan=new Questions(quesLine[0],quesLine[1],quesLine[2],quesLine[3],quesLine[4]);
			qtus.addQuestions(toolMan);
		}
	}
	
	
	public void setStuSrc(String src){//设置文件路径，默认为项目根目录下
		this.stuSrc=src;
	}
	
	public void setQuesSrc(String src){
		this.quesSrc=src;
	}
	
	public StuList getStuList(){//获取名单
		return this.stus;
	}
	
	public QuesList getQuesList(){//获取名单
		return this.qtus;
	}
}
