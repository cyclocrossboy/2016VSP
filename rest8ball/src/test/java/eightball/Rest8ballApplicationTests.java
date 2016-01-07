package eightball;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eightball.Rest8ballApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Rest8ballApplication.class)
@WebAppConfiguration
public class Rest8ballApplicationTests {

	@Test
	public void contextLoads() {
	}

}
