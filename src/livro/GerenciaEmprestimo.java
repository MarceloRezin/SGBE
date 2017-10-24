package livro;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import arquivos.Diretorio;
import arquivos.GravaJSON;

public class GerenciaEmprestimo {
	
	private Emprestimo emprestimo;
	private Livro livro;
	private ArrayList<Livro> livros;
	private ArrayList<Emprestimo> emprestimos;
	
	private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);
	
	public GerenciaEmprestimo(Emprestimo emprestimo, ArrayList<Livro> livros, ArrayList<Emprestimo> emprestimos, Livro livro) {
		super();
		this.emprestimo = emprestimo;
		this.livros = livros;
		this.emprestimos = emprestimos;
		this.livro = livro;
	}


	public void emprestar() {
		emprestimos.add(emprestimo);
		
		livro.setDisponivel(false);
		
		threadpool.submit(new GravaJSON<>(emprestimos, Diretorio.DIR_EMPRESTIMOS));
		threadpool.submit(new GravaJSON<>(livros, Diretorio.DIR_LIVROS));
	}
	
	public void devolver() {
		emprestimos.remove(localizarPorLivro());
		livro.setDisponivel(true);
		
		atualizarRegistros();
		
	}
	
	private Emprestimo localizarPorLivro() {
		for (Emprestimo ep : emprestimos) {
			if(ep.getNumeroRegistro() == livro.getNumeroRegistro()) {
				return ep;
			}
		}
		return null;
	}
	
	private void atualizarRegistros() {
		threadpool.submit(new GravaJSON<>(emprestimos, Diretorio.DIR_EMPRESTIMOS));
		threadpool.submit(new GravaJSON<>(livros, Diretorio.DIR_LIVROS));
	}
	
	
}
