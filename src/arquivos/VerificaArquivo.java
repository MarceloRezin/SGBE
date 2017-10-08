package arquivos;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

public class VerificaArquivo implements Callable<Void>{
	
	private final Diretorio dir;
	
	public VerificaArquivo(Diretorio dir) {
		this.dir = dir;
	}
	
	private boolean verificaDiretorio(Diretorio dir) {
		File file = new File(Diretorio.DIR_RAIZ.diretorio + dir.diretorio);
		
		return file.exists();
	}
	
	
	
	private void verificaECriaDiretorio(Diretorio dir) {
		if(verificaDiretorio(dir) == false) {
			new File(Diretorio.DIR_RAIZ.diretorio).mkdirs();
			
			try {
				new File(Diretorio.DIR_RAIZ.diretorio + dir.diretorio).createNewFile();
			} catch (IOException e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



	@Override
	public Void call() throws Exception {
		verificaECriaDiretorio(dir);	
		
		return null;
	}

}
