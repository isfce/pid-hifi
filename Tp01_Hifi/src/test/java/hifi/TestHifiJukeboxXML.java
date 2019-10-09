package hifi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles(value = "Jukebox")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/hifi/hifiXmlConfig.xml")
public class TestHifiJukeboxXML {
	@Autowired
	ApplicationContext contexte;
	@Autowired
	Ampli ampli;

	@Test
	public void hifiStandard() {
		// vérifie si le volume est à 8
		assertEquals(8, ampli.getVolume());
		// vérifie la présence d'un Tuner
		assertNotNull(ampli.getTuner());
		// vérifie la présence d'un lecteur multiCD
		assertEquals(MultiCdPlayer.class, ampli.getCdPlayer().getClass());
		// vérifie la présence d'un chargeur avec les Beatles "chargeurBeatles"
		assertNotNull(contexte.getBean("chargeurBeatles"));
		// vérifie le chargement du chargeur avec les Beatles
		assertEquals(contexte.getBean("chargeurBeatles"), ((MultiCdPlayer) ampli.getCdPlayer()).getChargeur());
		// vérifie la présence d'un chargeur avec les Stones "chargeurStones"
		assertNotNull(contexte.getBean("chargeurStones"));

	}

}
