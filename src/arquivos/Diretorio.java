package arquivos;

public enum Diretorio {
	
	DIR_LOCATARIOS("locatarios.json"), DIR_LIVROS("livros.json"), DIR_EMPRESTIMOS("emprestimos.json"), 
	DIR_ATRASOS("atrasos.json"), DIR_RAIZ("Arquivos/");
	
	public String diretorio;
	
	Diretorio(String dir) {
		this.diretorio = dir;
	}

}
