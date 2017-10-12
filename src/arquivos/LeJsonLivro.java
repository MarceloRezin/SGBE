package arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import livro.Livro;

public class LeJsonLivro implements Callable<ArrayList<Livro>> {
	
	public ArrayList<Livro> leJSONLivro() {
		
		Type type = new TypeToken<ArrayList<Livro>>() {}.getType();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(Diretorio.DIR_RAIZ.diretorio + Diretorio.DIR_LIVROS.diretorio));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ArrayList<Livro> livros = new Gson().fromJson(br, type);
		
		if(livros == null) {
			livros = new ArrayList<>();
		}
		
		return livros;
	}

	@Override
	public ArrayList<Livro> call() throws Exception {
		return leJSONLivro();
	}

}
