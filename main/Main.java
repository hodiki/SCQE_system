package main;
import java.io.IOException;
import java.util.Scanner;

import exClass.QuesList;
import exClass.Questions;
import exClass.StuList;
import exClass.Student;
import examination.SignIn;

import iOFlow.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//初始量设置
		int needQues=5; //做题数目
		String saveSrc="./log.txt"; //日志文件保存路径以及文件名
		String Message = "答题日志："; //日志内容
		
		String sno="20175491"; //学号
		String password="123"; //密码
		Student stuIn=new Student(null,null,null); //登录成功的学生
		String ans="A"; //答案
		int ansQuesSum; //答题数
		int trueSum; //总对题
		int errorSum; //总错题
		
		String stuAns[] = new String[needQues]; //学生答题情况之答案
		int stuTrueAns[] = new int[needQues]; //学生答题情况之正确情况
		String tureAns[] = new String[needQues]; //标准答案组
		String quesMessage[] = new String[needQues]; //题干组
		String quesMessAns[] = new String[needQues];  //题目答案组
		
		
		
		//初始化学生库stuList
		StuList stuList=new StuList("stuList");
		ReadList readStuList = new ReadList();
		readStuList.setStuSrc("./班级名单2.txt");
		readStuList.startStu();
		stuList=readStuList.getStuList();//获得学生库
		
		//初始化题库quesList
		QuesList quesList=new QuesList("quesList");
		ReadList readQuesList = new ReadList();
		readQuesList.setQuesSrc("./题库2.txt");
		readQuesList.startQues();
		quesList=readQuesList.getQuesList();//获得题库
		

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//主菜单
		System.out.println("--------------------------------");
		System.out.println("\n欢迎使用由误人子弟出品的选择题考试系统\n");
		System.out.println("--------------------------------");
		while(true) {
			System.out.println("请输入您的学号和密码进行登录");
			System.out.println("请输入您的学号");
			sno = scanner.next();
			System.out.println("请输入您的密码");
			password = scanner.next();
			
			//登录
			SignIn sign=new SignIn();
			if(sign.sIn(readStuList,sno,password)==1){
				stuIn=stuList.getStudent(sno);//读取登录成功的学生
				stuIn.signIn();//设置登录状态
				System.out.println(stuIn.getSno()+stuIn.getSname()+"登录成功，准备开始答题");
				Message=Message+"\n"+stuIn.getSno()+stuIn.getSname()+"登录成功";
			}else {
				System.out.println("登录失败");
			}
			
			
			//初始化记录
			ansQuesSum=0;
			trueSum=0;
			errorSum=0;
			
			//开始答题
			if(stuIn.getSignState()==1) { //确认已经处于登录状态

				System.out.println("您的回答请使用大写字母");
				System.out.println("准备好请输入任意内容");
				@SuppressWarnings("unused")
				String areYouReadly = scanner.next();
				
				for(int i = 0;i<needQues;i++) {
					//出题
					Questions ques=QuesList.randomQues(quesList.size(),quesList); //输入取题范围和题库实例
					System.out.println("\n"+ques.getQno()+"."+ques.getSubject()+"\n"+ques.getAnswers());
					quesMessage[i]=ques.getQno()+"."+ques.getSubject(); //记录题干
					quesMessAns[i]=ques.getAnswers(); //记录答案组
					System.out.println("请输入答案：");
					ans = scanner.next();
					stuAns[i]=ans; //记录学生答案
					tureAns[i]=ques.getTrueAnswers(); //记录正确答案
					//检查答案
					if(QuesList.checkAns(ques,ans)==1) { 	//回答正确
						System.out.println("回答正确");
						stuTrueAns[i]=1; //记录答题情况
						trueSum++;
					}else { 								//回答错误
						System.out.println("回答错误");
						stuTrueAns[i]=0; //记录答题情况
						errorSum++;
					}
					ansQuesSum++; //记录答题数量
				}
				
				//答题结束
				System.out.println("答题结束，以下是您的答题情况：");
				System.out.println("您总共回答了"+ansQuesSum+"题");
				Message=Message+"\n您总共回答了"+ansQuesSum+"题";
				System.out.println("您错了"+errorSum+"题");
				Message=Message+"\n您错了"+errorSum+"题";
				System.out.println("您的得分为："+trueSum);
				Message=Message+"\n您的得分为："+trueSum;
				for(int i = 0;i<needQues;i++) {
					System.out.println(quesMessage[i]);
					Message=Message+"\n"+quesMessage[i];
					System.out.println(quesMessAns[i]);
					Message=Message+"\n"+quesMessAns[i];
					System.out.println("您的答案为："+stuAns[i]+"正确答案为："+tureAns[i]);
					Message=Message+"\n您的答案为："+stuAns[i]+"正确答案为："+tureAns[i];
					System.out.println("您这道题得分："+stuTrueAns[i]+"\n");
					Message=Message+"\n您这道题得分："+stuTrueAns[i]+"\n";
				}
				
				Message=Message+"\n--------------------------------";
				Message=Message+"\n\n感谢您使用由误人子弟出品的选择题考试系统，欢迎下次再来\n";
				Message=Message+"\n--------------------------------";
				
				FileUtil.genModuleTpl(saveSrc,Message); //创建日志文件
				
				//考试结束
				System.out.println("--------------------------------");
				System.out.println("\n感谢您使用由误人子弟出品的选择题考试系统，欢迎下次再来\n");
				System.out.println("--------------------------------");
				
				}
				
				//re菜单
				System.out.println("输入0退出答题，输入其它任意内容后重新登录并进行答题");
				String re = scanner.next();
				if(re.equals("0")) {
					break;
				}
			}
	}

}
