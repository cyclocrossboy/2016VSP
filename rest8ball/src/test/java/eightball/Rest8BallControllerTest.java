package eightball;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.util.MatcherAssertionErrors.assertThat;
import static org.hamcrest.Matchers.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@RunWith (SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration (classes = Rest8ballApplication.class)
@WebAppConfiguration
@IntegrationTest
public class Rest8BallControllerTest {

	 final String BASE_URL = "http://localhost:8080/eightball";
	static  final Logger LOG = LoggerFactory.getLogger(Answer.class);

	@Test
	public void answerquestion_test() {
		final String question = "Will this work?";
		String url = BASE_URL + "?question=" + question;
		
		RestTemplate rest = new TestRestTemplate();
		
		ResponseEntity<String> response =
				rest.exchange(url, HttpMethod.GET, null, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		String answercreated = response.getBody();
		assertThat(answercreated, notNullValue() );
		LOG.info("the value is " + answercreated);

	}
	
	@Test
	public void exceptionemptyquestion_test(){
		
		final String question = "";
		String url = BASE_URL + "?question=" + question;
		
		RestTemplate rest = new TestRestTemplate();
		
		ResponseEntity<String> response =
				rest.exchange(url, HttpMethod.GET, null, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
		String answercreated = response.getBody();
		assertThat(answercreated, notNullValue() );
		LOG.info("exception value is " + answercreated);

	}
	
}
