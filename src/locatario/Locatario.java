package locatario;

public class Locatario {

	private String nomeCompleto;
	private String data;
	private String endereco;
	private String referencia;
	private String serie;
	private String nomePai;
	private String nomeMae;
	
	
	
	public Locatario(String nomeCompleto, String data, String endereco, String referencia, String serie, String nomePai,
			String nomeMae) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.data = data;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
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
	
	
	
}
