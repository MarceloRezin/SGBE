/**
 * ADICIONAR DESCRIÇÃO DA CLASSE
 */

package livro;

import java.time.LocalDate;
import java.util.Date;

import locatario.Locatario;

public class Emprestimo {
	
	private String nomeLocatario;
	private int numeroRegistro;
	private LocalDate data;
	private LocalDate entrega;
	private Boolean atraso;
		
	//Construtor com Paramentros.	
	public Emprestimo(String nomeLocatario, int numeroRegistro, LocalDate data, LocalDate entrega, Boolean atraso) {
		super();
		this.nomeLocatario = nomeLocatario;
		this.numeroRegistro = numeroRegistro;
		this.data = data;
		this.entrega = entrega;
		this.atraso = atraso;
	}
	//Gets e Sets
	public String getNomeLocatario() {
		return nomeLocatario;
	}
	public void setNomeLocatario(String nomeLocatario) {
		this.nomeLocatario = nomeLocatario;
	}
	public int getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalDate getEntrega() {
		return entrega;
	}
	public void setEntrega(LocalDate entrega) {
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
		
		
		return  "Locador: " + nomeLocatario + "\n" +
				"Livro: " + numeroRegistro + "\n" +
				"Data: " + data + "/n" +
				"Entrega: " + entrega + "/n" +
				"Atrasado:" + at;
	}
	
	
	
}
