package arquivos;

public enum Diretorio {
	
	DIR_LOCATARIOS("locatarios.json"), DIR_LIVROS("livros.json"), DIR_EMPRESTIMOS("emprestimos.json"), 
	DIR_EMPRESTIMOS_CONCLUIDOS("emprestimos_concluidos.json"), DIR_RAIZ("Arquivos/");
	
	public String diretorio;
	
	Diretorio(String dir) {
		this.diretorio = dir;
	}

}
