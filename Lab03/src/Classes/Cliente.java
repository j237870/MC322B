package Classes;
import java.util.List;

public class Cliente {
	private String nome;
	private String endereco;
	private List<Veiculo> listaVeiculos;
	
	// Construtor
	public Cliente(String nome, String endereco, List<Veiculo> listaVeiculos) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
	}
	
	// Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public String toString() {
		String out = "";
		out += "Cliente: " + getNome() + " de endereço " + getEndereco() + " com " + getListaVeiculos().size() + "veiculos.";
		return out;
	}
	
}