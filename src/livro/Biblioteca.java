/**
 * ADICIONAR DESCRIÇÃO DA CLASSE
 */

package livro;

import java.util.ArrayList;

public class Biblioteca {

	private ArrayList<Livro> livros;
	
	public Biblioteca(ArrayList<Livro> livros) {
		this.livros = livros;
	}
	
	
	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	//Consulta pelo numero de registro e retorna o livro.
	public Livro ConsultaNumeroRegistro(int numeroRegistro) {
		
		for (Livro livro : livros) {
			if(livro.getNumeroRegistro() == numeroRegistro) {
				return livro;
			}
		}		
		return null;
	}
	
	//Consulra pelo Titulo e Retorna o Livro.
	public Livro ConsultaTitulo(String titulo) {
		
		for (Livro livro : livros) {
			if(livro.getTitulo() == titulo) {
				return livro;
			}
		}		
		return null;
	}
	
	
	//Lista Todos os Livros.
	public ArrayList<Livro> ListarTodos(){
		
		ArrayList<Livro> todos = new ArrayList<>();
		
		
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
