package arquivos;

import java.util.ArrayList;

import locatario.Locatario;

public class Teste {

	public static void main(String[] args) {
		
		
		
		Locatario l = new Locatario("Marcelo Rezin", "s sd", "06-08-98", "sdd sd", "ewee e", "sdsds dsd", "sdsdds s");
		
		ArrayList<Locatario> al = new ArrayList<>();
		
		al.add(l);
		
		GerenciaJSON gj = new GerenciaJSON();
		
		new VerificaArquivo().verificaECriaDiretorio(Diretorio.DIR_LOCATARIOS);
		
		gj.gravarJSON(al, Diretorio.DIR_LOCATARIOS);
		
		al = gj.leJSONLocatario(Diretorio.DIR_LOCATARIOS);
		
		System.out.println(al.get(0).toString());

	}

}
