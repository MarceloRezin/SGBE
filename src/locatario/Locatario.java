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
		
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.referencia = referencia;
		this.serie = serie;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
	}
	
	//Gets e Sets
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	//Retorno da String com todos os dados formatados.
	@Override
	public String toString(){
		
		return "Nome: " + nomeCompleto + "\n" +
				"Data Nascimento: "+ dataNascimento + "\n" +
				"Endereço: "+ endereco + "\n" +
				"Referencia: "+ referencia + "\n" + 
				"Série: "+ serie + "\n" +
				"Nome do Pai: "+ nomePai + "\n" +
				"Nome da Mãe: "+ nomeMae + "\n";
	}
	
	
}
