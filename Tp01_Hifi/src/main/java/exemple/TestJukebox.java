package exemple;

import java.io.IOException;

import hifi.Ampli;
import hifi.CdPlayer;
import hifi.ChargeurCdFactory;
import hifi.IChargeur;
import hifi.MultiCdPlayer;
import hifi.Tuner;
import hifi.IAmpli.Sources;

public class TestJukebox {

	public static void main(String[] args) {
		try {
			//Crée un chargeur avec la liste des disques des Beatles
			IChargeur chargeurB = ChargeurCdFactory.createChargeur("/hifi/CDBeatles.properties");
			//Crée un chargeur avec la liste des disques des Stones
			IChargeur chargeurS = ChargeurCdFactory.createChargeur("/hifi/CDStones.properties");
			// Crée un Lecteur de MultiCD et un Tuner
			MultiCdPlayer multiCD=new MultiCdPlayer();
			Tuner tuner = new Tuner();
			//Crée un ampli connecté au multiCD et au Tuner
			Ampli ampli = new Ampli(6, multiCD, tuner);
			//Charge chargeur dans le jukebox
			multiCD.setChargeur(chargeurB);
			//sélectionne la source  CD
			ampli.setSource(Sources.CD);
			//Simule la leture du disque
			multiCD.autoPlay();
			//Charge chargeur Stone dans le jukebox
			multiCD.setChargeur(chargeurS);
			// Simule la leture du disque
			multiCD.autoPlay();
			//change la source en Tuner
			ampli.setSource(Sources.TUNER);
			//Ajuste le volume
			ampli.setVolume(3);
		} catch (IOException e) {
			System.err.println("Problème de chargement des disques");
		}


	}

}
