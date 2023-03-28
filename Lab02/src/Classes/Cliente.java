package Classes;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	// Construtor
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	// Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
