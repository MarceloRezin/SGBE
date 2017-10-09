/**
 * ADICIONAR DESCRIÇÃO DA CLASSE
 */

package locatario;


public class Locatario {

	//Declaração de Variaveis.
	private String nomeCompleto;
	private String dataNascimento;
	private String endereco;
	private String referencia;
	private String serie;
	private String nomePai;
	private String nomeMae;
	
	
	//Construtor com Parametro.
	public Locatario(String nomeCompleto, String dataNascimento, String endereco, String referencia, String serie, String nomePai,
			String nomeMae) {
		super();
		
		this.nomeCompleto = nomeCompleto.replaceAll(" ", "+");
		this.dataNascimento = dataNascimento.replaceAll("/", "-");
		this.endereco = endereco.replaceAll(" ", "+");
		this.referencia = referencia.replaceAll(" ", "+");
		this.serie = serie.replaceAll(" ", "+");
		this.nomePai = nomePai.replaceAll(" ", "+");
		this.nomeMae = nomeMae.replaceAll(" ", "+");
	}
	
	//Gets e Sets
	public String getNomeCompleto() {
		return nomeCompleto.replaceAll("\\+", " ");
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto.replaceAll(" ", "+");
	}
	public String getDataNascimento() {
		return dataNascimento.replaceAll("-", "/");
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento.replaceAll("/", "-");
	}
	public String getEndereco() {
		return endereco.replaceAll("\\+", " ");
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco.replaceAll(" ", "+");
	}
	public String getReferencia() {
		return referencia.replaceAll("\\+", " ");
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia.replaceAll(" ", "+");
	}
	public String getSerie() {
		return serie.replaceAll("\\+", " ");
	}
	public void setSerie(String serie) {
		this.serie = serie.replaceAll(" ", "+");
	}
	public String getNomePai() {
		return nomePai.replaceAll("\\+", " ");
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai.replaceAll(" ", "+");
	}
	public String getNomeMae() {
		return nomeMae.replaceAll("\\+", " ");
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae.replaceAll(" ", "+");
	}
	
	//Retorno da String com todos os dados formatados.
	@Override
	public String toString(){
		
		return "Nome: " + nomeCompleto.replaceAll("\\+", " ") + "\n" +
				"Data Nascimento: "+ dataNascimento.replaceAll("-", "/") + "\n" +
				"Endereço: "+ endereco.replaceAll("\\+", " ") + "\n" +
				"Referencia: "+ referencia.replaceAll("\\+", " ") + "\n" + 
				"Série: "+ serie.replaceAll("\\+", " ") + "\n" +
				"Nome do Pai: "+ nomePai.replaceAll("\\+", " ") + "\n" +
				"Nome da Mãe: "+ nomeMae.replaceAll("\\+", " ") + "\n";
	}
	
	
}
