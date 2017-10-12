/**
 * ADICIONAR DESCRIÇÃO DA CLASSE
 */

package livro;

import java.util.Date;
import locatario.Locatario;

public class Emprestimo {
	
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
		//Atribui a verificão de Atraso no Emprestimo.
		
		String at = "Não";		
		
		if(atraso) {
			at = "Sim";
		}
		
		
		return  "Locador: " + locador + "\n" +
				"Livro: " + livro + "\n" +
				"Data: " + data + "/n" +
				"Entrega: " + entrega + "/n" +
				"Atrasado:" + at;
	}
	
	
	
}
