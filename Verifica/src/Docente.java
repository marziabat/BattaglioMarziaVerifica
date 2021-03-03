
public class Docente extends Persona{
	private String classe;
	public Docente(String cognome, String nome, String codice, String data, String classe) {
		super(cognome, nome, codice, data);
		this.classe = classe;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
}
