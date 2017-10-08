package arquivos;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LeJSON {
	
	public <T> ArrayList<T> leJSON(Diretorio diretorio){
		ArrayList<T> lista = null;
		
		try {
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new FileReader(Diretorio.DIR_RAIZ.diretorio + diretorio.diretorio));

			Type ls = new TypeToken<T>(){}.getType(); 
			
			lista = gson.fromJson(br, ls);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
		
		
	}
}
