package eightball;

import java.util.ArrayList;
import java.util.Random;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonView;

import org.slf4j.Logger;
public class Answer {


	
	private final Long id;
	private String question;

	static  final Logger LOG = LoggerFactory.getLogger(Answer.class);

	
	public Answer(long id, String question)  {
		this.id = id;
		this.question = question;
		// TODO Auto-generated constructor stub
	}

	public String getAnswer()   {
		// TODO Auto-generated method stub
		Random rand = new Random();
		ArrayList<String> answer = new ArrayList<String>(20);
		answer.add(0, "As I see it, yes");
		answer.add(1, "It is certain");
		answer.add(2, "It is decidedly so");
		answer.add(3, "Most likely");
		answer.add(4, "Outlook good");
		answer.add(5, "Signs point to yes");
		answer.add(6, "Without a doubt");
		answer.add(7, "Yes");
		answer.add(8, "Yes - definitely");
		answer.add(9, "You may rely on it");
		answer.add(10, "Reply hazy, try again");
		answer.add(11, "Better not tell you now");
		answer.add(12, "Cannot predict now");
		answer.add(13, "Concentrate and ask again");
		answer.add(14, "Don't count on it");
		answer.add(15, "My reply is no");
		answer.add(16, "My sources say no");
		answer.add(17, "Outlook not so good");
		answer.add(18, "Very doubtful");
		answer.add(19, "Ask again later");

		int iNum = rand.nextInt(20);
		LOG.info("Question: " + getQuestion() + "   Answer: " + answer.get(iNum).toString());
		return answer.get(iNum).toString();
	}

	public Object getId() {
		// TODO Auto-generated method stub
	
		return id;
	}

	public Object getQuestion()  {
		// TODO Auto-generated method stub

			return question;
		}
	



}
