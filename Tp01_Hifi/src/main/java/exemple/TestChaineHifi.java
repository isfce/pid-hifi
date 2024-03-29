package exemple;

import java.io.IOException;

import hifi.Ampli;
import hifi.CdPlayer;
import hifi.ChargeurCdFactory;
import hifi.DisqueCD;
import hifi.IAmpli.Sources;
import hifi.ICd;
import hifi.IChargeur;
import hifi.Tuner;

public class TestChaineHifi {

	public static void main(String[] args) {
		try {
			//Création d'un CD
			ICd cd1 = new DisqueCD("Titre CD1","M1,M2,M3,M4");
			// Crée un chargeur avec la liste des disques des Beatles
			IChargeur chargeur = ChargeurCdFactory.createChargeur("/hifi/CDBeatles.properties");
			// Crée un Lecteur de CD et un Tuner
			CdPlayer lecteurCD = new CdPlayer();
			Tuner tuner = new Tuner();
			// Crée un ampli connecté au CD et au Tuner
			Ampli ampli = new Ampli(6, lecteurCD, tuner);
			// Charge un disque dans le lecteur de CD
			lecteurCD.setCd(chargeur.getDisque(1));
			// sélectionne la source CD
			ampli.setSource(Sources.CD);
			// Simule la leture du disque
			lecteurCD.autoPlay();
			//Charge le CD1
			lecteurCD.setCd(cd1);
			// Simule la leture du disque
			lecteurCD.autoPlay();
			
			// change la source en Tuner
			ampli.setSource(Sources.TUNER);
			// Ajuste le volume
			ampli.setVolume(3);
		} catch (IOException e) {
			System.err.println("Problème de chargement des disques");
		}

	}

}
