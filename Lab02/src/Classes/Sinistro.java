package Classes;

import java.util.Random;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	
	// Construtor
	public Sinistro(int id, String data, String endereco) {
		this.id = id;
		this.data = data;
		this.endereco = endereco;
	}
	public Sinistro(String data, String endereco) {
		this.id = getRandomID();
		this.data = data;
		this.endereco = endereco;
	}
	
	private int getRandomID() {
		return new Random().nextInt();
	}
	// Getters e setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	
}