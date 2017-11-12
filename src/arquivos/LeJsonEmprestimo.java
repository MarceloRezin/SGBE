package arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import livro.Emprestimo;

public class LeJsonEmprestimo implements Callable<ArrayList<Emprestimo>> {
	
	public ArrayList<Emprestimo> leJSONEmprestimo() {
		
		Type type = new TypeToken<ArrayList<Emprestimo>>() {}.getType();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(Diretorio.DIR_RAIZ.diretorio + Diretorio.DIR_EMPRESTIMOS.diretorio));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ArrayList<Emprestimo> emprestimos = new Gson().fromJson(br, type);
		
		if(emprestimos == null) {
			return emprestimos = new ArrayList<>();
		}
		
		for (Emprestimo emprestimo : emprestimos) {
			if(emprestimo.getDataEmprestimo().isAfter(emprestimo.getDataPrevistaEntrega()) && emprestimo.getDataEntrega()==null) {
				emprestimo.setAtraso(true);
			}
		}
		
		return emprestimos;
	}

	@Override
	public ArrayList<Emprestimo> call() throws Exception {
		return leJSONEmprestimo();
	}

}
