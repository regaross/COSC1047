package question2;

public class FillInTheBlank {

	private String question;
	private String answer;
	
	
	FillInTheBlank(String q, String a){
		setQuestion(q);
		setAnswer(a);
	}
	
	FillInTheBlank(FillInTheBlank in){
		question = in.question;
		answer = in.answer;
	}
	
	public void setQuestion(String q){
		question = q;
	}
	
	public void setAnswer(String a){
		answer = a;
	}

	public String getQuestion(){ return question; }
	public String getAnswer(){ return answer; }
	
	public String toString(){
		return "FillInTheBlank[Question:\"" + question + "\", Answer:\"" + answer + "]"; 
	}
}
