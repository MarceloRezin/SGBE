package arquivos;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import livro.Emprestimo;
import livro.Livro;
import locatario.Locatario;

public class GerenciaJSON {
	
	
	public <T> void gravarJSON(ArrayList<T> lista, Diretorio diretorio) {
		Gson gson = new Gson();
		
		
		String json = "[";
		
		int i = 1; // contador para saber se é a ultima iteração do for each
		
		for (T obj : lista) {
			
			json+= gson.toJson(obj);
			
			if(i != lista.size()) {
				json += ",";
			}else {
				json += "]";
			}
			
			i++;
		}
		
		try {
			
			FileWriter writer = new FileWriter(Diretorio.DIR_RAIZ.diretorio + diretorio.diretorio);
			writer.write(json);
			writer.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private <T> ArrayList<T> leJSON(Diretorio diretorio){
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
	
	public ArrayList<Locatario> leJSONLocatario(Diretorio diretorio) {
		ArrayList<Locatario> locatarios = new ArrayList<>();
		
		Gson gson = new Gson();
		
		ArrayList<Object> listaObjs = leJSON(diretorio);
		
		for(Object ob : listaObjs) {
			Locatario l = gson.fromJson(ob.toString(), Locatario.class);
			
			locatarios.add(l);
		}
		
		return locatarios;
	}
	
	public ArrayList<Livro> leJSONLivro(Diretorio diretorio) {
		ArrayList<Livro> livro = new ArrayList<>();
		
		Gson gson = new Gson();
		
		ArrayList<Object> listaObjs = leJSON(diretorio);
		
		for(Object ob : listaObjs) {
			Livro l = gson.fromJson(ob.toString(), Livro.class);
			
			livro.add(l);
		}
		
		return livro;
	}
	
	public ArrayList<Emprestimo> leJSONEmprestimo(Diretorio diretorio) {
		ArrayList<Emprestimo> emprestimo = new ArrayList<>();
		
		Gson gson = new Gson();
		
		ArrayList<Object> listaObjs = leJSON(diretorio);
		
		for(Object ob : listaObjs) {
			Emprestimo e = gson.fromJson(ob.toString(), Emprestimo.class);
			
			emprestimo.add(e);
		}
		
		return emprestimo;
	}
}
