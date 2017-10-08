package arquivos;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import com.google.gson.Gson;

import livro.Livro;

public class LeJsonLivro extends LeJSON implements Callable<ArrayList<Livro>> {
	
	public ArrayList<Livro> leJSONLivro() {
		ArrayList<Livro> livro = new ArrayList<>();
		
		Gson gson = new Gson();
		
		ArrayList<Object> listaObjs = leJSON(Diretorio.DIR_LIVROS);
		
		if(listaObjs == null) {
			listaObjs = new ArrayList<>();
		}
		
		for(Object ob : listaObjs) {
			Livro l = gson.fromJson(ob.toString(), Livro.class);
			
			livro.add(l);
		}
		
		return livro;
	}

	@Override
	public ArrayList<Livro> call() throws Exception {
		return leJSONLivro();
	}

}
