
public class ATA extends Persona{
	private String inquadramento;
	public ATA(String cognome, String nome, String codice, String data, String inquadramento) {
		super(cognome, nome, codice, data);
		this.inquadramento = inquadramento;
	}
	
	public String getInquadramento() {
		return inquadramento;
	}
	public void setInquadramento(String inquadramento) {
		this.inquadramento = inquadramento;
	}

}
