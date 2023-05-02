package Classes;
import java.util.List;
import java.util.Date;

public class ClientePJ extends Cliente {
	private String cnpj;
	private Date dataFundacao;
	
	// Construtor
	public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos,
			String cnpj, Date dataFundacao) {
		// chama o construtor da superclasse
		super(nome, endereco, listaVeiculos);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
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
	
	public boolean validarCNPJ(String cnpj) {
		cnpj = cnpj.replaceAll("[^0-9]+", "");
		if (cnpj.length() != 14)
			return false;
		int i = 1;
		while (cnpj.charAt(i - 1) == cnpj.charAt(i)) {
			if(i == cnpj.length() - 1)
				return false;
			i++;
		}
		// primeiro digito verificador
		int digitoVerificador = 0;
		for (int j=0; j<12; j++) {
			if (j<4)
				digitoVerificador = digitoVerificador + (5 - j)*Character.getNumericValue(cnpj.charAt(i));
			else
				digitoVerificador = digitoVerificador + (13 - j)*Character.getNumericValue(cnpj.charAt(i));
		}
		digitoVerificador = digitoVerificador % 11;
		if (digitoVerificador <= 1)
			digitoVerificador = 0;
		else
			digitoVerificador = 11 - digitoVerificador;
		if (digitoVerificador != Character.getNumericValue(cnpj.charAt(12)))
			return false;
		
		// segundo digito verificador
		digitoVerificador = 0;
		for (int j=0; j<12; j++) {
			if (j<5)
				digitoVerificador = digitoVerificador + (6 - j)*Character.getNumericValue(cnpj.charAt(i));
			else
				digitoVerificador = digitoVerificador + (14 - j)*Character.getNumericValue(cnpj.charAt(i));
		}
		digitoVerificador = digitoVerificador % 11;
		if (digitoVerificador <= 1)
			digitoVerificador = 0;
		else
			digitoVerificador = 11 - digitoVerificador;
		if (digitoVerificador != Character.getNumericValue(cnpj.charAt(13)))
			return false;
		return true;		
	}
	
	public String toString() {
		String out = "";
		out += "Cliente: " + getNome() + " de endereço " + getEndereco() + " com " + getListaVeiculos().size() + "veiculos." +
				"\nCNPJ: " + getCNPJ() + ", Data Fundacao: " + getDataFundacao();
		return out;
	}
}