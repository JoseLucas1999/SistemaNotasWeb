package Model;

public class Alunos {
	int ra;
	String nome;
	Notas notas;
	int media = 0;
	String situacao;

	
	public Alunos() {
		super();
	}

	public Alunos(String nome, Notas notas) {
		super();
		this.nome = nome;
		this.notas = notas;
	}

	public Alunos(int ra, String nome, Notas notas, int mediaFinal, String situacao) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.notas = notas;
		this.media = mediaFinal;
		this.situacao = situacao;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Notas getNotas() {
		return notas;
	}

	public void setNotas(Notas notas) {
		this.notas = notas;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int mediaFinal) {
		this.media = mediaFinal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String aprovado) {
		this.situacao = aprovado;
	}

}
