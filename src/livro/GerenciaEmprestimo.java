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
	
	private static final ExecutorService threadpool = Executors.newFixedThreadPool(2);
	
	public GerenciaEmprestimo(Emprestimo emprestimo, ArrayList<Livro> livros, ArrayList<Emprestimo> emprestimos, Livro livro) {
		super();
		this.emprestimo = emprestimo;
		this.livros = livros;
		this.emprestimos = emprestimos;
		this.livro = livro;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public void emprestar() {
		emprestimos.add(emprestimo);
		
		livro.setDisponivel(false);
		
		atualizarRegistros();
	}
	
	public void devolver() {
		livro.setDisponivel(true);
		
		atualizarRegistros();
		
	}
	
	public Emprestimo localizarPorLivro() {
		for (Emprestimo ep : emprestimos) {
			if(ep.getNumeroRegistro() == livro.getNumeroRegistro()) {
				return ep;
			}
		}
		return null;
	}
	
	public void atualizarRegistros() {
		threadpool.submit(new GravaJSON<>(emprestimos, Diretorio.DIR_EMPRESTIMOS));
		threadpool.submit(new GravaJSON<>(livros, Diretorio.DIR_LIVROS));
	}
	
	
}
