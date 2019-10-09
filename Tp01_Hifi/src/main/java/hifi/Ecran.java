package hifi;

public class Ecran implements IAffichage {
	private String text="--------------";
	private String device=" INCONNU ";
	
	@Override
	public void setText(String text) {
		this.text=text;
		System.out.println(device+" INFO: "+text);
	}

	@Override
	public String getDevice() {
		return device;
	}

	@Override
	public String getText() {
		
		return text;
	}

	@Override
	public void setDevice(String device) {
		this.device=device;
		
	}

}
