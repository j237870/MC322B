package Classes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		//Cliente cliente = new Cliente("Joâo Vitor Gomes do Nascimento", "007.160.420-02", "03/12/2000", 22, "Rua Jupara, 427");
		
		//Sinistro sinistro = new Sinistro("28/03/2023", "Rua Maria Teixeira Mourão Maresti, 419");
		//Veiculo veiculo = new Veiculo("NEX-5098", "CBT Jipe", "Javali 3.0 4x4 Diesel");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Seguradora seguradora = new Seguradora("Porto Seguro", "(19) 98488-3314", "julio_raul_ferreira@plaman.com.br", "Praça Professora Zélia Seixas de Siqueira, 332");
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o nome da pessoa física: ");
		String nomepf = input.nextLine();
		System.out.println("Informe o endereço: ");
		String enderecopf = input.nextLine();
		System.out.println("Informe o cpf: ");
		String cpf = input.nextLine();
		System.out.println("Informe o gênero: ");
		String genero = input.nextLine();
		System.out.println("Informe a data da Licença (DD/MM/AAAA): ");
		String dataLicenca = input.nextLine();
		System.out.println("Informe a educação: ");
		String educacao = input.nextLine();
		System.out.println("Informe a data de nascimento (DD/MM/AAAA): ");
		String dataNascimento = input.nextLine();
		System.out.println("Informe a classe econômica: ");
		String classeEconomica = input.nextLine();
		System.out.println("Informe a placa do veículo: ");
		String placa = input.nextLine();
		System.out.println("Informe a marca do veículo: ");
		String marca = input.nextLine();
		System.out.println("Informe o modelo do veículo: ");
		String modelo = input.nextLine();
		System.out.println("Informe o ano de fabricação do veículo: ");
		String anoFabricacao = input.nextLine();
		
		List<Veiculo> listaVeiculopf = new ArrayList<>();
		listaVeiculopf.add(new Veiculo(placa, marca, modelo, Integer.valueOf(anoFabricacao)));
		
		ClientePF cliente = new ClientePF(nomepf, enderecopf, listaVeiculopf, cpf, genero, sdf.parse(dataLicenca), educacao, sdf.parse(dataNascimento), classeEconomica);
		if (cliente.validarCPF(cpf))
			seguradora.cadastrarCliente(cliente);
		
		System.out.println("Informe o nome da pessoa jurídica: ");
		String nomepj = input.nextLine();
		System.out.println("Informe o endereço: ");
		String enderecopj = input.nextLine();
		System.out.println("Informe o cnpj: ");
		String cnpj = input.nextLine();
		System.out.println("Informe a data da fundação (DD/MM/AAAA): ");
		String dataFundacao = input.nextLine();
		System.out.println("Informe a placa do veículo: ");
		String placa2 = input.nextLine();
		System.out.println("Informe a marca do veículo: ");
		String marca2 = input.nextLine();
		System.out.println("Informe o modelo do veículo: ");
		String modelo2 = input.nextLine();
		System.out.println("Informe o ano de fabricação do veículo: ");
		String anoFabricacao2 = input.nextLine();
		
		List<Veiculo> listaVeiculopj = new ArrayList<>();
		listaVeiculopf.add(new Veiculo(placa2, marca2, modelo2, Integer.valueOf(anoFabricacao2)));
		
		ClientePJ cliente2 = new ClientePJ(nomepj, enderecopj, listaVeiculopj, cnpj, sdf.parse(dataFundacao));
		if (cliente2.validarCNPJ(cnpj))
			seguradora.cadastrarCliente(cliente2);
		
		seguradora.listarClientes();
		
		System.out.println("Informe o nome da pessoa física: ");
		String nomepf2 = input.nextLine();
		System.out.println("Informe o endereço: ");
		String enderecopf2 = input.nextLine();
		System.out.println("Informe o cpf: ");
		String cpf2 = input.nextLine();
		System.out.println("Informe o gênero: ");
		String genero2 = input.nextLine();
		System.out.println("Informe a data da Licença (DD/MM/AAAA): ");
		String dataLicenca2 = input.nextLine();
		System.out.println("Informe a educação: ");
		String educacao2 = input.nextLine();
		System.out.println("Informe a data de nascimento (DD/MM/AAAA): ");
		String dataNascimento2 = input.nextLine();
		System.out.println("Informe a classe econômica: ");
		String classeEconomica2 = input.nextLine();
		System.out.println("Informe a placa do veículo: ");
		String placa3 = input.nextLine();
		System.out.println("Informe a marca do veículo: ");
		String marca3 = input.nextLine();
		System.out.println("Informe o modelo do veículo: ");
		String modelo3 = input.nextLine();
		System.out.println("Informe o ano de fabricação do veículo: ");
		String anoFabricacao3 = input.nextLine();
		
		List<Veiculo> listaVeiculopf2 = new ArrayList<>();
		listaVeiculopf.add(new Veiculo(placa3, marca3, modelo3, Integer.valueOf(anoFabricacao3)));
		
		ClientePF cliente3 = new ClientePF(nomepf2, enderecopf2, listaVeiculopf2, cpf2, genero2, sdf.parse(dataLicenca2), educacao2, sdf.parse(dataNascimento2), classeEconomica2);
		if (cliente3.validarCPF(cpf2))
			seguradora.cadastrarCliente(cliente3);
		
		seguradora.listarClientes();
		
		seguradora.removerCliente(nomepf2);
		
		seguradora.listarClientes();
		
		seguradora.gerarSinistro(nomepf);
		
		seguradora.visualizarSinistro(nomepj);
		
		seguradora.listarSinistros();
		
		input.close();
	}
}

