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
	
	public Livro consulta(String registro) {
		
		for (Livro livro : livros) {
			String num = "" + livro.getNumeroRegistro();
			
			if(num.contains(registro)) {
				return livro;
			}
		}
		
		return null;
	}

	//Consulta pelo numero de registro e retorna o livro.
	public ArrayList<Livro> consultaNumeroRegistro(String numeroRegistro) {
		
		ArrayList <Livro> busca = new ArrayList<>();
		
		for (Livro livro : livros) {
			
			String num = "" + livro.getNumeroRegistro();
			if(num.contains(numeroRegistro)) {
				busca.add(livro);
			}
		}	
		
		return busca;
	}
	
	//Consulra pelo Titulo e Retorna o Livro.
	public ArrayList<Livro> consultaTitulo(String titulo) {
		
		ArrayList <Livro> busca = new ArrayList<>();
		
		for (Livro livro : livros) {
			if(livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				busca.add(livro);
			}
		}		
		return busca;
	}
	
	
	
	public boolean addLivro(Livro livro) {
		for (Livro l : livros) {
			if(l.getNumeroRegistro() == livro.getNumeroRegistro()) {
				return false;
			}
		}
			this.livros.add(livro);
			return true;
	}
	
	public boolean editaLivro(Livro l) {
		for(Livro liv : livros) {
			if(liv.getNumeroRegistro() == l.getNumeroRegistro()) {
				liv.setAutor(l.getAutor());
				liv.setLocalizacao(l.getLocalizacao());
				liv.setTitulo(l.getTitulo());
				return true;
			}
		}
		return false;
	}
	
	public void removeLivro(Livro livro) {
		this.livros.remove(livro);
	}
}
