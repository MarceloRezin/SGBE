package arquivos;

import java.io.File;
import java.io.IOException;

public final class VerificaArquivo {
	
	public boolean verificaDiretorio(Diretorio dir) {
		File file = new File(Diretorio.DIR_RAIZ.diretorio + dir.diretorio);
		
		return file.exists();
	}
	
	public void verificaECriaDiretorio(Diretorio dir) {
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

}
