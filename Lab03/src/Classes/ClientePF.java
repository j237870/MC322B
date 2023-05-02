package Classes;
import java.util.List;
import java.util.Date;

public class ClientePF extends Cliente {
	private String cpf;
	private String genero;
	private Date dataLicenca;
	private String educacao;
	private Date dataNascimento;
	private String classeEconomica;
	
	// Construtor
	public ClientePF(String nome, String endereco, List<Veiculo> listaVeiculos,
			String cpf, String genero, Date dataLicenca, String educacao,
			Date dataNascimento, String classeEconomica) {
		// chama o construtor da superclasse
		super(nome, endereco, listaVeiculos);
		this.cpf = cpf ;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}
	
	// Getters e setters
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	public boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]+", "");
		if (cpf.length() != 11)
			return false;
		int i = 1;
		while (cpf.charAt(i - 1) == cpf.charAt(i)) {
			if(i == cpf.length() - 1)
				return false;
			i++;
		}
		// primeiro digito verificador
		int digitoVerificador = 0;
		for (int j=0; j<9; j++)
			digitoVerificador = digitoVerificador + (10 - j)*Character.getNumericValue(cpf.charAt(i));
		digitoVerificador = digitoVerificador % 11;
		if (digitoVerificador <= 1)
			digitoVerificador = 0;
		else
			digitoVerificador = 11 - digitoVerificador;
		if (digitoVerificador != Character.getNumericValue(cpf.charAt(9)))
			return false;
		
		// segundo digito verificador
		digitoVerificador = 0;
		for (int j=0; j<9; j++)
			digitoVerificador = digitoVerificador + (10 - j)*Character.getNumericValue(cpf.charAt(i + 1));
		digitoVerificador = digitoVerificador % 11;
		if (digitoVerificador <= 1)
			digitoVerificador = 0;
		else
			digitoVerificador = 11 - digitoVerificador;
		if (digitoVerificador != Character.getNumericValue(cpf.charAt(10)))
			return false;
		return true;
	}
	
	public String toString() {
		String out = "";
		out += "Cliente: " + getNome() + " de endereço " + getEndereco() + " com " + getListaVeiculos().size() + "veiculos." +
				"\nCPF: " + getCPF() + ", Genero: " + getGenero() + ", Data Licenca: " + getDataLicenca() + ", Educacao: " + getEducacao() +
				", Data de Nascimento: " + getDataNascimento() + " e Classe Economica: " + getClasseEconomica();
		return out;
	}
}