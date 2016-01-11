package eightball;


import java.util.concurrent.atomic.AtomicLong;
import eightball.Info;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;



@RestController
public class Rest8BallController {
	private final AtomicLong counter = new AtomicLong();

	
	@RequestMapping(method = RequestMethod.GET, value = "/{eightball}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.TEXT_XML_VALUE })
	
	public @ResponseBody Answer question(@RequestParam(value = "question", defaultValue = "What") String query) {
		if (query.contentEquals("What")) {
		

        throw new IllegalArgumentException("{Hint: Please specify a question other than the default 'What'}");
		}

	
		return new Answer(counter.incrementAndGet(), query);

	}





	@ExceptionHandler(IllegalArgumentException.class)


 	ResponseEntity<String> handleNotFounds(Exception e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

	}


}
