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
		
		//��ʼ������
		int needQues=5; //������Ŀ
		String saveSrc="./log.txt"; //��־�ļ�����·���Լ��ļ���
		String Message = "������־��"; //��־����
		
		String sno="20175491"; //ѧ��
		String password="123"; //����
		Student stuIn=new Student(null,null,null); //��¼�ɹ���ѧ��
		String ans="A"; //��
		int ansQuesSum; //������
		int trueSum; //�ܶ���
		int errorSum; //�ܴ���
		
		String stuAns[] = new String[needQues]; //ѧ���������֮��
		int stuTrueAns[] = new int[needQues]; //ѧ���������֮��ȷ���
		String tureAns[] = new String[needQues]; //��׼����
		String quesMessage[] = new String[needQues]; //�����
		String quesMessAns[] = new String[needQues];  //��Ŀ����
		
		
		
		//��ʼ��ѧ����stuList
		StuList stuList=new StuList("stuList");
		ReadList readStuList = new ReadList();
		readStuList.setStuSrc("./�༶����2.txt");
		readStuList.startStu();
		stuList=readStuList.getStuList();//���ѧ����
		
		//��ʼ�����quesList
		QuesList quesList=new QuesList("quesList");
		ReadList readQuesList = new ReadList();
		readQuesList.setQuesSrc("./���2.txt");
		readQuesList.startQues();
		quesList=readQuesList.getQuesList();//������
		

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//���˵�
		System.out.println("--------------------------------");
		System.out.println("\n��ӭʹ���������ӵܳ�Ʒ��ѡ���⿼��ϵͳ\n");
		System.out.println("--------------------------------");
		while(true) {
			System.out.println("����������ѧ�ź�������е�¼");
			System.out.println("����������ѧ��");
			sno = scanner.next();
			System.out.println("��������������");
			password = scanner.next();
			
			//��¼
			SignIn sign=new SignIn();
			if(sign.sIn(readStuList,sno,password)==1){
				stuIn=stuList.getStudent(sno);//��ȡ��¼�ɹ���ѧ��
				stuIn.signIn();//���õ�¼״̬
				System.out.println(stuIn.getSno()+stuIn.getSname()+"��¼�ɹ���׼����ʼ����");
				Message=Message+"\n"+stuIn.getSno()+stuIn.getSname()+"��¼�ɹ�";
			}else {
				System.out.println("��¼ʧ��");
			}
			
			
			//��ʼ����¼
			ansQuesSum=0;
			trueSum=0;
			errorSum=0;
			
			//��ʼ����
			if(stuIn.getSignState()==1) { //ȷ���Ѿ����ڵ�¼״̬

				System.out.println("���Ļش���ʹ�ô�д��ĸ");
				System.out.println("׼������������������");
				@SuppressWarnings("unused")
				String areYouReadly = scanner.next();
				
				for(int i = 0;i<needQues;i++) {
					//����
					Questions ques=QuesList.randomQues(quesList.size(),quesList); //����ȡ�ⷶΧ�����ʵ��
					System.out.println("\n"+ques.getQno()+"."+ques.getSubject()+"\n"+ques.getAnswers());
					quesMessage[i]=ques.getQno()+"."+ques.getSubject(); //��¼���
					quesMessAns[i]=ques.getAnswers(); //��¼����
					System.out.println("������𰸣�");
					ans = scanner.next();
					stuAns[i]=ans; //��¼ѧ����
					tureAns[i]=ques.getTrueAnswers(); //��¼��ȷ��
					//����
					if(QuesList.checkAns(ques,ans)==1) { 	//�ش���ȷ
						System.out.println("�ش���ȷ");
						stuTrueAns[i]=1; //��¼�������
						trueSum++;
					}else { 								//�ش����
						System.out.println("�ش����");
						stuTrueAns[i]=0; //��¼�������
						errorSum++;
					}
					ansQuesSum++; //��¼��������
				}
				
				//�������
				System.out.println("������������������Ĵ��������");
				System.out.println("���ܹ��ش���"+ansQuesSum+"��");
				Message=Message+"\n���ܹ��ش���"+ansQuesSum+"��";
				System.out.println("������"+errorSum+"��");
				Message=Message+"\n������"+errorSum+"��";
				System.out.println("���ĵ÷�Ϊ��"+trueSum);
				Message=Message+"\n���ĵ÷�Ϊ��"+trueSum;
				for(int i = 0;i<needQues;i++) {
					System.out.println(quesMessage[i]);
					Message=Message+"\n"+quesMessage[i];
					System.out.println(quesMessAns[i]);
					Message=Message+"\n"+quesMessAns[i];
					System.out.println("���Ĵ�Ϊ��"+stuAns[i]+"��ȷ��Ϊ��"+tureAns[i]);
					Message=Message+"\n���Ĵ�Ϊ��"+stuAns[i]+"��ȷ��Ϊ��"+tureAns[i];
					System.out.println("�������÷֣�"+stuTrueAns[i]+"\n");
					Message=Message+"\n�������÷֣�"+stuTrueAns[i]+"\n";
				}
				
				Message=Message+"\n--------------------------------";
				Message=Message+"\n\n��л��ʹ���������ӵܳ�Ʒ��ѡ���⿼��ϵͳ����ӭ�´�����\n";
				Message=Message+"\n--------------------------------";
				
				FileUtil.genModuleTpl(saveSrc,Message); //������־�ļ�
				
				//���Խ���
				System.out.println("--------------------------------");
				System.out.println("\n��л��ʹ���������ӵܳ�Ʒ��ѡ���⿼��ϵͳ����ӭ�´�����\n");
				System.out.println("--------------------------------");
				
				}
				
				//re�˵�
				System.out.println("����0�˳����⣬���������������ݺ����µ�¼�����д���");
				String re = scanner.next();
				if(re.equals("0")) {
					break;
				}
			}
	}

}
