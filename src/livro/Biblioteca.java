/**
 * ADICIONAR DESCRIÇÃO DA CLASSE
 */

package livro;

import java.util.ArrayList;

public class Biblioteca {

	private ArrayList<Livro> livros;
	
	//Consulra pelo Numero de Registro e Retorna o Livro.
	public Livro ConsultaNumeroRegistro(int numeroRegistro) {
		
		if(livros == null) {
			return null;
		}
		
		for (Livro livro : livros) {
			if(livro.getNumeroRegistro() == numeroRegistro) {
				return livro;
			}
		}		
		return null;
	}
	
	//Consulra pelo Titulo e Retorna o Livro.
	public Livro ConsultaTitulo(String titulo) {
		
		if (livros == null) {
			return null;
		}
		
		for (Livro livro : livros) {
			if(livro.getTitulo() == titulo) {
				return livro;
			}
		}		
		return null;
	}
	
	
	//Lista Todos os Livros.
	public ArrayList<Livro> ListarTodos(){
		
		ArrayList<Livro> todos = null;
		
		if(livros ==  null) {
			return todos;
		}		
		for (Livro livro : livros) {
			
			todos.add(livro);
		}		
		return todos;
	}	
	
	public void AddLivro(Livro livro) {
		this.livros.add(livro);
	}
	
	public void RemoveLivro(Livro livro) {
		this.livros.remove(livro);
	}
}
