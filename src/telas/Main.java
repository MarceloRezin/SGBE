package telas;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import arquivos.Diretorio;
import arquivos.GravaJSON;
import arquivos.LeJsonEmprestimo;
import arquivos.LeJsonLivro;
import arquivos.LeJsonLocatario;
import arquivos.VerificaArquivo;
import livro.Emprestimo;
import livro.Livro;
import locatario.Locatario;

public class Main {
	
	private static final ExecutorService threadpool = Executors.newFixedThreadPool(8);

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		//Verificando todos os diretorios ao mesmo tempo
		VerificaArquivo va0 = new VerificaArquivo(Diretorio.DIR_LOCATARIOS);
		VerificaArquivo va1 = new VerificaArquivo(Diretorio.DIR_LIVROS);
		VerificaArquivo va2 = new VerificaArquivo(Diretorio.DIR_EMPRESTIMOS);
		
		Future<Void> future = threadpool.submit(va0);
		Future<Void> future1 = threadpool.submit(va1);
		Future<Void> future2 = threadpool.submit(va2);
		
		while(!future.isDone() && !future1.isDone() && !future2.isDone()) {
			
		}
		
		//Recuperando todos os registros simultaneamente
		LeJsonLocatario ljl = new LeJsonLocatario();
		LeJsonLivro ljli = new LeJsonLivro();
		LeJsonEmprestimo lje = new LeJsonEmprestimo();
		
		Future<ArrayList<Locatario>> fL = threadpool.submit(ljl);
		Future<ArrayList<Livro>> fLi = threadpool.submit(ljli);
		Future<ArrayList<Emprestimo>> fE = threadpool.submit(lje);
		
		while(!fL.isDone() && !fLi.isDone() && !fE.isDone()) {}
		
		try {
			ArrayList<Locatario> locatarios = fL.get();
			ArrayList<Livro> livros = fLi.get();
			ArrayList<Emprestimo> emprestimos = fE.get();
			
			TelaPrincipal tp = new TelaPrincipal(locatarios, livros, emprestimos);
			
			threadpool.submit(new GravaJSON<>(emprestimos, Diretorio.DIR_EMPRESTIMOS));
			
			tp.setVisible(true);
		} catch (InterruptedException | ExecutionException e1) {
			JOptionPane.showMessageDialog(null, "Ocorreu um problema na leitura dos arquivos!", "Erro", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		
		threadpool.shutdown();
	}

}
