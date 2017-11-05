/**
 * ADICIONAR DESCRIÇÃO DA CLASSE
 */

package livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
	
	private String nomeLocatario;
	private int numeroRegistro;
	private LocalDate dataEmprestimo;
	private LocalDate dataPrevistaEntrega;
	private LocalDate dataEntrega;
	private boolean atraso;
		
	public Emprestimo(String nomeLocatario, int numeroRegistro, LocalDate dataEmprestimo, LocalDate dataPrevistaEntrega, boolean atraso) {
		super();
		this.nomeLocatario = nomeLocatario;
		this.numeroRegistro = numeroRegistro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataEntrega = null;
		this.atraso = atraso;
	}

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

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public boolean getAtraso() {
		return atraso;
	}

	public void setAtraso(boolean atraso) {
		this.atraso = atraso;
	}

	//Retorno da String com todos os dados formatados.
	@Override
	public String toString() {
		DateTimeFormatter formatador = 
		DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return  "Usuário: " + nomeLocatario + "\n" +
				"Livro: " + numeroRegistro + "\n" +
				"Data de empréstimo : " + dataEmprestimo.format(formatador) + "\n" +
				"Data prevista para entrega: " + dataPrevistaEntrega.format(formatador) + "\n" +
				"Data de entrega: " + (dataEntrega!=null ? dataEntrega.format(formatador) : "Ainda não foi entrege") + "\n" +
				"Atrasado: " + (atraso==true ? "Sim" : "Não");
	}
	
	
	
}
