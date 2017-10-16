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

	//Consulta todos os nomes que contem em si a string passada
	public ArrayList<Locatario> consultaPorNome(String nome) {
		ArrayList<Locatario> locs = new ArrayList<>();		
		
		for (Locatario locatario : locatarios){
			if(locatario.getNomeCompleto().toLowerCase().contains(nome.toLowerCase())) {
				locs.add(locatario);
			}
		}
		return locs;		
	}
	
	//Conslta pela serie e retorna a turma.
	public ArrayList<Locatario> consultaPorSerie(String serie) {
		
		ArrayList<Locatario> turma = new ArrayList<>();
		
		//Percorre o Array buscando pela serie e armazenando em turma.
		for(Locatario locatario : locatarios) {			
			if(locatario.getSerie().toLowerCase().contains(serie.toLowerCase())) {
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
