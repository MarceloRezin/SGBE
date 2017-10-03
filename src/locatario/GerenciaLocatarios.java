/**
 * ADICIONAR DESCRIÇÃO DA CLASSE
 */

package locatario;

import java.util.ArrayList;

public class GerenciaLocatarios {
	//Declaro a Lista de Locadores.
	private ArrayList<Locatario> locador = new ArrayList<>();
	
	//Consulta pelo Nome e Retorna o Locador.
	public Locatario consultaPorNome(String nome) {
		if(locador == null) {
			return null;
		}
		for (Locatario locatario : locador){
			if(locatario.getNomeCompleto() == nome) {
				return locatario;
			}
		}
		return null;		
	}
	
	//Conslta pela Serie e Retorna a Turma.
	public ArrayList<Locatario> consultaPorSerie(String serie) {
		if(locador == null) {
			return null;
		}
		ArrayList<Locatario> turma = null;
		//Percorre o Array Buscando pela Serie e Armazenando em Turma.
		for(Locatario locatario : locador) {			
			if(locatario.getSerie() == serie) {
				turma.add(locatario);
			}			
		}
		return turma;
	}
	
	//Adiciona um Novo Locador na Lista.
	public void addLocador(Locatario locador) {
		this.locador.add(locador);
	}
	
	//Removo um Locador da Lista.
	public void removeLocador(Locatario locador) {
		if(locador == null) {
			return;
		}
		this.locador.remove(locador);		
	}
		
}
