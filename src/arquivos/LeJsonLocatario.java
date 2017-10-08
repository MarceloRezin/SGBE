package arquivos;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import com.google.gson.Gson;
import locatario.Locatario;

public class LeJsonLocatario extends LeJSON implements Callable<ArrayList<Locatario>> {
	
	public ArrayList<Locatario> leLocatario() {
		ArrayList<Locatario> locatarios = new ArrayList<>();
		
		Gson gson = new Gson();
		
		ArrayList<Object> listaObjs = leJSON(Diretorio.DIR_LOCATARIOS);
		
		if(listaObjs == null) {
			listaObjs = new ArrayList<>();
		}
		
		for(Object ob : listaObjs) {
			Locatario l = gson.fromJson(ob.toString(), Locatario.class);
			
			locatarios.add(l);
		}
		
		return locatarios;
	}

	@Override
	public ArrayList<Locatario> call() throws Exception {
		return leLocatario();
	}

}
