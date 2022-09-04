package modelo;

public class Permissoes {
	// Atributos
	private int id_permissao;
	private String tipo;
	
	//Construtor
	public Permissoes() {
		
	}
	
	public Permissoes(int id_permissao, String tipo) {
		this.id_permissao = id_permissao;
		this.tipo = tipo;
	}
	
	//Geters e Seters
	
	public void setId_permissao(int id_permissao) {
		this.id_permissao = id_permissao;
	}
	
	public int getId_permissao() {
		return this.id_permissao;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	
}
