package eightball;

import static org.junit.Assert.*;

import eightball.Answer;
import eightball.StubAnswer;
import org.junit.Test;
import org.hamcrest.CoreMatchers;




public class AnswerTest {



		final long id = 1;
		final String question = "Will this work?";

		StubAnswer aList = new StubAnswer ();
		Answer answer = new Answer(id, question);


	@Test
	public void test() throws Exception {
		
		assertEquals(Long.valueOf(1), this.answer.getId());
		assertEquals(answer.getQuestion(), question);
		assertThat(aList.Answer(), CoreMatchers.hasItem(answer.getAnswer()));
		//assertNotNull(answer.getAnswer());
	}

}
