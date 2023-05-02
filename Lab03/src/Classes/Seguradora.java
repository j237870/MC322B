package Classes;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;
	
	// Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.setListaSinistros(new ArrayList<Sinistro>());
		this.setListaClientes(new ArrayList<Cliente>());
	}
	
	// Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getEndereco() {
		return endereco;
	}
		
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		return true;
	}
	
	public boolean removerCliente(String cliente) {
		for (int i=0; i<listaClientes.size(); i++)
			if (listaClientes.get(i).getNome().equals(cliente))
				listaClientes.remove(i);
		return true;
	}
		
	public void listarClientes() {
		for (Cliente c: listaClientes) {
			System.out.println(c.toString());
		}
	}
	
	public boolean gerarSinistro(String cliente) {
		Cliente c = null;
		for (int i=0; i<listaClientes.size(); i++)
			if (listaClientes.get(i).getNome().equals(cliente)) {
				c = listaClientes.get(i);
				break;
			}
		if (c == null)
			return false;
		
		return listaSinistros.add(new Sinistro(new Random().nextInt(), new Date().toString(), "", this, null, c));
	}
	
	public boolean visualizarSinistro(String cliente) {
		int qtdSinistro = 0;
		for (Sinistro s : listaSinistros) {
			if (s.getCliente().getNome().equals(cliente)) {
				System.out.println(s.toString());
				qtdSinistro++;
			}
		}
		return qtdSinistro > 0;
	}
	
	public void listarSinistros() {
		for(Sinistro s: listaSinistros) {
			System.out.println(s.toString());
		}
	}
}