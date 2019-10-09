package hifi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@ActiveProfiles(value = "Jukebox")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/hifi/hifiXmlConfig.xml")
public class TestHifiClassiqueXML {
	// @Autowired
	// ApplicationContext contexte;

	@Autowired
	Ampli ampli;

	@Test
	public void hifiStandard() {
		//vérifie si le volume est à 8
		assertEquals(8,ampli.getVolume());
		
	}
}
