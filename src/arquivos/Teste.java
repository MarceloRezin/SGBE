package arquivos;

import java.util.ArrayList;

import locatario.Locatario;

public class Teste {

	public static void main(String[] args) throws Exception {
		
		
		
		Locatario l = new Locatario("M", "s sd", "06-08-98", "sdd sd", "ewee e", "sdsds dsd", "sdsdds s");
		
		
		ArrayList<Locatario> al = new ArrayList<>();
		
		for(int i=0; i<50000; i++) {
			l.setNomeCompleto(i+"");
			al.add(l);
			
		}
		
		new GravaJSON<>(al, Diretorio.DIR_LOCATARIOS).call();
		
		
		ArrayList<Locatario> ag = new LeJsonLocatario().call();
		
		for (Locatario locatario : ag) {
			System.out.println(locatario.toString());
		}
	}

}
