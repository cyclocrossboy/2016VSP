package eightball;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class Rest8BallController {
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(method = RequestMethod.GET, value = "/{eightball}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE})
	
	public @ResponseBody Answer question(@RequestParam(value="question", defaultValue="What") String query){
			if(query.contentEquals("What")) {
				throw new IllegalArgumentException("Please specify a question other than the default 'What'");
	}
    return new Answer(counter.incrementAndGet(), query);

    }



@ExceptionHandler(IllegalArgumentException.class)
//void handleBadRequests(HttpServletResponse response) throws IOException {
//    response.sendError(HttpStatus.BAD_REQUEST.value(), "Please specify a question other than the default 'What'");
ResponseEntity<String> handleNotFounds(Exception e){
	return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//    response.sendError(HttpStatus.BAD_REQUEST.value(), "Please try again and with a non empty string as 'name'");
}
}
