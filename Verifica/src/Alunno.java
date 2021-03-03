
public class Alunno extends Persona{
	
	private String classe, sezione;

	public Alunno(String cognome, String nome, String codice, String data, String classe, String sezione) {
		super(cognome, nome, codice, data);
		this.classe = classe;
		this.sezione = sezione;
	}
	
	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}
}