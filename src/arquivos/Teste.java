package arquivos;

import java.util.ArrayList;

import locatario.Locatario;

public class Teste {

	public static void main(String[] args) throws Exception {
		
		Locatario l = new Locatario("Maelo", "06/08/1998", "ee", "sdsd", "44", "c", "d");
		
		ArrayList<Locatario> ls = new ArrayList<>();
		
		ls.add(l);
		
		new GravaJSON<>(ls, Diretorio.DIR_LOCATARIOS).call();
		
		ls = new LeJsonLocatario().call();
		
		System.out.println(ls.get(0).toString());
		
	}

}
