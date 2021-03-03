public abstract class Persona {
	private String cognome, nome, codice, data;
	
	public Persona(String cognome, String nome, String codice, String data) {
		this.cognome = cognome;
		this.nome = nome;
		this.codice = codice;
		this.data = data;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getData(){
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
