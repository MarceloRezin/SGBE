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
		//Percorre o Array Buscando pelo Nome.
		
		for (Locatario locatario : locador) {
			if(locatario.getNomeCompleto() == nome) {
				return locatario;
			}

		}
		return null;		
	}
	
	//Conslta pela Serie e Retorna a Turma.
	public ArrayList<Locatario> consultaPorSerie(String serie) {
		ArrayList<Locatario> turma = null;
		//Percorre o Array Buscando pela Serie e Armazenando em Turma.
		for(int i = 0; i < locador.size(); i++) {			
			Locatario l = locador.get(i);
			if(l.getSerie() == serie) {
				turma.add(l);
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
		this.locador.remove(locador);		
	}
		
}
