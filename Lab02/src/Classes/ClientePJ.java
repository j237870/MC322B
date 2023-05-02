package Classes;
import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {
	private String cnpj;
	private Date dataFundacao;
	
	// Construtor
	public ClientePJ(String nome, String endereco, Date dataLicenca,
			String educacao, String genero, String classeEconomica,
			ArrayList<Veiculo> listaVeiculos, String cnpj, Date dataFundacao) {
		// chama o construtor da superclasse
		super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
		this.setCNPJ(cnpj) ;
		this.setDataFundacao(dataFundacao);
	}
	
	// Getters e setters
	public String getCNPJ() {
		return cnpj;
	}

	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	
}
