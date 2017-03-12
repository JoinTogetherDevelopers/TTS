package org.dorageecorp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class TTSApplicationTests {

	@Test
	public void testEncriptLoginPassword() {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		log.info(bc.encode("test1"));
	}

}
