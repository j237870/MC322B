package Classes;
import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente {
	private String cpf;
	private Date dataNascimento;
	
	// Construtor
	public ClientePF(String nome, String endereco, Date dataLicenca,
			String educacao, String genero, String classeEconomica,
			ArrayList<Veiculo> listaVeiculos, String cpf, Date dataNascimento) {
		// chama o construtor da superclasse
		super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
		this.cpf = cpf ;
		this.dataNascimento = dataNascimento;
	}
	
	// Getters e setters
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
		for (int j=0; j<9; ++j)
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
		for (int j=0; j<9; ++j)
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
}