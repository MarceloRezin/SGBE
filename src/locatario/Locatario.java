package locatario;

public class Locatario {

	private String nomeCompleto;
	private String dataNascimento;
	private String endereco;
	private String referencia;
	private String serie;
	private String nomePai;
	private String nomeMae;
	
	
	
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
	
	@Override
	public String toString(){
		
		String locatario = "Nome: "+ getNomeCompleto() + "\n" +
							"Data Nascimento: "+ getDataNascimento() + "\n" +
							"Endereço: "+ getEndereco() + "\n" +
							"Referencia: "+ getReferencia() + "\n" + 
							"Série: "+ getSerie() + "\n" +
							"Nome do Pai: "+ getNomePai() + "\n" +
							"Nome da Mãe: "+ getNomeMae() + "\n";
		return  locatario;
		
	}
	
	
	
}
