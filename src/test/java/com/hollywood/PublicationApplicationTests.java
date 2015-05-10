package com.hollywood;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hollywood.PublicationApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PublicationApplication.class)
@WebAppConfiguration
public class PublicationApplicationTests {

	@Test
	public void contextLoads() {
	}

}
