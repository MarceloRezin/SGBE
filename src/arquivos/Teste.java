package arquivos;

import java.util.ArrayList;

import locatario.Locatario;

public class Teste {

	public static void main(String[] args) throws Exception {
		
		
		//Locatario l = new Locatario("Marcelo Rezin", "06/08/1998", "Estrada Geral, Vila maria, Treze de Maio", "sdsd", "44", "c", "d");
		//Locatario l1 = new Locatario("José Antonio", "02/12/1698", "Estrada Geral", "sdsd", "44", "c", "d");
		//Locatario l3 = new Locatario("Marcos", "16/03/1458", "Estrada Geral, Vila maria", "sd sd", "44", "c", "d");
		
		
		ArrayList<Locatario> ls = new ArrayList<>();
		
		//ls.add(l);
		//ls.add(l1);
		//ls.add(l3);
		
		//new GravaJSON<>(ls, Diretorio.DIR_LOCATARIOS).call();
		
		ls = new LeJsonLocatario().call();
		
		for (Locatario locatario : ls) {
			System.out.println(locatario.toString());
		}
		
	}

}
