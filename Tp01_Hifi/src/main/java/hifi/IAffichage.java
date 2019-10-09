package hifi;

public interface IAffichage {
	/**
	 * 
	 * @param text:
	 *            texte à afficher sur le média
	 */
	void setText(String text);

	/**
	 * Retourne le contenu du média
	 * 
	 * @return texte de du média
	 */
	String getText();

	/**
	 * retourne l'appareil auquel se rapporte le média d'affichage
	 */
	String getDevice();

	/**
	 * Permet d'indiquer quel appareil utilise le média
	 * @param device l'appareil qui envoit ses données
	 */
	void setDevice(String device);
}
