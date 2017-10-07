/**
 * ADICIONAR DESCRIÇÃO DA CLASSE
 */

package locatario;

import java.util.ArrayList;

public class GerenciaLocatarios {
	

	private ArrayList<Locatario> locatarios;
	
	public GerenciaLocatarios(ArrayList<Locatario> locatarios) {
		this.locatarios = locatarios;
	}
	
	public void setLocatarios(ArrayList<Locatario> locatarios) {
		this.locatarios = locatarios;
	}

	//Consulta pelo Nome e Retorna o Locador.
	public Locatario consultaPorNome(String nome) {
		//Percorre o Array Buscando pelo Nome.
		for (Locatario locatario : locatarios){
			
			if(locatario.getNomeCompleto() == nome) {
				return locatario;
			}
		}
		return null;		
	}
	
	//Conslta pela serie e retorna a turma.
	public ArrayList<Locatario> consultaPorSerie(String serie) {
		
		ArrayList<Locatario> turma = new ArrayList<>();
		
		//Percorre o Array buscando pela serie e armazenando em turma.
		for(Locatario locatario : locatarios) {			
			if(locatario.getSerie() == serie) {
				turma.add(locatario);
			}			
		}
		
		return turma;
	}
	
	//Adiciona um locador a lista
	public void addLocatario(Locatario locatario) {
		this.locatarios.add(locatario);
	}
	

	//Remove o locador d
	public void removeLocatario(Locatario locatario) {
		this.locatarios.remove(locatario);		
	}
		
}
