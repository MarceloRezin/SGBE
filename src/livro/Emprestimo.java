/**
 * ADICIONAR DESCRIÃ‡ÃƒO DA CLASSE
 */

package livro;
//Importação da Bibliotecas Nescessaria.
import java.util.Date;
import locatario.Locatario;

public class Emprestimo {
	
	//Declaração de Variaveis.
	private Locatario locador;
	private Livro livro;
	private Date data;
	private Date entrega;
	private Boolean atraso;
		
	//Construtor com Paramentros.	
	public Emprestimo(Locatario locador, Livro livro, Date data, Date entrega, Boolean atraso) {
		super();
		this.locador = locador;
		this.livro = livro;
		this.data = data;
		this.entrega = entrega;
		this.atraso = atraso;
	}
	//Gets e Sets
	public Locatario getLocador() {
		return locador;
	}
	public void setLocador(Locatario locador) {
		this.locador = locador;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getEntrega() {
		return entrega;
	}
	public void setEntrega(Date entrega) {
		this.entrega = entrega;
	}
	public Boolean isAtraso() {
		return atraso;
	}
	public void setAtraso(Boolean atraso) {
		this.atraso = atraso;
	}
	
	//Retorno da String com todos os dados formatados.
	@Override
	public String toString() {
		//Atribui a verificação de Atraso no Emprestimo.
		String at;		
		if(atraso) {
			at = "Sim";
		}
		else {
			at = "Em dia";
		}
		
		
		return "Locador: " + locador + "\n" +
		"Livro: " + livro + "\n" +
		"Data: " + data + "/n" +
		"Entrega: " + entrega + "/n" +
		"Atrasado:" + at;
	}
	
	
	
}
