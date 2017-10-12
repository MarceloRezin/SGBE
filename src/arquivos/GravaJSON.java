package arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import com.google.gson.Gson;


public class GravaJSON<T> implements Callable<Void> {
	
	ArrayList<T> lista;
	Diretorio diretorio;
	
	public GravaJSON(ArrayList<T> lista, Diretorio diretorio) {
		this.lista = lista;
		this.diretorio = diretorio;
	}
	
	private void gravarJSON(ArrayList<T> locatarios, Diretorio dir) {
		
		String json = new Gson().toJson(locatarios);
		
		try {
			
			FileWriter writer = new FileWriter(Diretorio.DIR_RAIZ.diretorio + diretorio.diretorio);
			writer.write(json);
			writer.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public Void call() throws Exception {
		gravarJSON(lista, diretorio);
		
		return null;
	}

}
