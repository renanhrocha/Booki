package modelo;

import java.sql.Date;

public class Destino {

	// Atributos
	private int id_destino;
	private String local_destino;
	private Float valor_destino;
	private Date data_destino;
	
	
	//Construtor
	public Destino() {
		
	}
	
	public Destino(int id_destino, String local_destino, Float valor_destino, Date data_destino) {
		this.id_destino = id_destino;
		this.local_destino = local_destino;
		this.valor_destino = valor_destino;
		this.data_destino = data_destino;
	}
	
	//Geters e Seters
	
	public void setId_detino(int id_destino) {
		this.id_destino = id_destino;
	}
	
	public int getId_destino() {
		return this.id_destino;
	}
	
	public void setLocal_destino(String local_destino) {
		this.local_destino = local_destino;
	}
	
	public String getLocal_destino() {
		return this.local_destino;
	}

	public void setValor_destino(float valor_destino){
		this.valor_destino = valor_destino;
	}

	public Float getValor_destino(){
		return this.valor_destino;
	}

	public void setData_destino(Date data_destino){
		this.data_destino = data_destino;
	}
	
	public Date getData_destino(){
		return this.data_destino;
	}

	//Metodo mostrar
	public String mostrar() {
		return "Id: " + this.id_destino + " local: " + this.local_destino + "valor_destino: " + this.valor_destino + "data: " + this.data_destino;
	}

	public boolean contains(String nomeExcluir) {
		return false;
	}

    public void remove(String nomeExcluir) {
    }
}