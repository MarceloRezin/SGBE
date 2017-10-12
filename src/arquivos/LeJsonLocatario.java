package arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import locatario.Locatario;

public class LeJsonLocatario implements Callable<ArrayList<Locatario>> {
	
	public ArrayList<Locatario> leLocatario() {
		
		Type type = new TypeToken<ArrayList<Locatario>>() {}.getType();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(Diretorio.DIR_RAIZ.diretorio + Diretorio.DIR_LOCATARIOS.diretorio));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ArrayList<Locatario> locatarios = new Gson().fromJson(br, type);
		
		if(locatarios == null) {
			locatarios = new ArrayList<>();
		}
		
		return locatarios;
	}

	@Override
	public ArrayList<Locatario> call() throws Exception {
		return leLocatario();
	}

}
