package arquivos;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import com.google.gson.Gson;

import livro.Emprestimo;

public class LeJsonAtraso extends LeJSON implements Callable<ArrayList<Emprestimo>> {
	
	public ArrayList<Emprestimo> leJSONEmprestimo() {
		ArrayList<Emprestimo> emprestimo = new ArrayList<>();
		
		Gson gson = new Gson();
		
		ArrayList<Object> listaObjs = leJSON(Diretorio.DIR_ATRASOS);
		
		if(listaObjs == null) {
			listaObjs = new ArrayList<>();
		}
		
		for(Object ob : listaObjs) {
			Emprestimo e = gson.fromJson(ob.toString(), Emprestimo.class);
			
			emprestimo.add(e);
		}
		
		return emprestimo;
	}
	

	@Override
	public ArrayList<Emprestimo> call() throws Exception {
		return leJSONEmprestimo();
	}

}
