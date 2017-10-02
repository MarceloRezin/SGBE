/**
 * ADICIONAR DESCRIÇÃO DA CLASSE
 */

package livro;

public class Livro {
	
	
	//Declaração de Variaveis
	private int numeroRegistro;
	private String titulo;
	private String autor;
	private String localizacao;
	private Boolean disponivel;
	
	
	//Contrutor com Paramentros.	
	public Livro(int numeroRegistro, String titulo, String autor, String localizacao, Boolean disponivel) {
		super();
		this.numeroRegistro = numeroRegistro;
		this.titulo = titulo;
		this.autor = autor;
		this.localizacao = localizacao;
		this.disponivel = disponivel;
	}
	
	//Gets e Sets
	public int getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	
	//Retorno da String com todos os dados formatados.
	@Override
	public String toString() {
		//Atribui a Disponibilidade ao Livro.
		String dis;		
		if(disponivel) {
			dis = "Disponivel";
		}
		else {
			dis = "Indisponivel";
		}
		
		return	"Numero De Registro: " + numeroRegistro + "/n" +
				"Titulo: " + titulo + "/n" +
				"Autor: " + autor + "/n" +
				"Localização: "	+ localizacao + "/n"+ 
				"Disponivel: " + dis;
	}
	
}
