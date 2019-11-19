package exClass;

public class Questions {
	String qno;//��Ŀ���
	String questionTypes;//��Ŀ����
	String subject;//��Ŀ
	String answers;//����ѡ��
	String trueAnswer;//��ȷ��
	
	public Questions(String qno,String questionTypes,String subject,String answers,String trueAnswer){
		this.qno=qno;
		this.questionTypes=questionTypes;
		this.subject=subject;
		this.answers=answers;
		this.trueAnswer=trueAnswer;
	}
	
	public Questions(String qno){
		this.qno=qno;
		
	}
	
	public String getQno() {
		return this.qno;
	}
	
	public String getQuestionTypes() {
		return this.questionTypes;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public String getAnswers() {
		return this.answers;
	}
	
	public String getTrueAnswers() {
		return this.trueAnswer;
	}
	
	public int checkAnswer(String answers){
		answers=answers.toUpperCase(); //��ͳһ��ɴ�д
		if(this.answers.equals(answers)){
			return 1;
		}
		return 0;
		
	}
}
