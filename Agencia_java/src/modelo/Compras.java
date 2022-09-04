package modelo;

import java.sql.Date;


public class Compras {
	//Atributos
	private int id_compra;
	private Double valor_compra;
	private Date data_compra;
	
	//Construtores
	public Compras(int id_compra) {
		
	}
	
	public Compras(int id_compra, Date data_compra, Double valor_compra) {
		this.id_compra = id_compra;
		this.data_compra = data_compra;
		this.valor_compra = valor_compra;
	}

	//Getters e Setters
	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public Date getData_compra() {
		return data_compra;
	}

	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}

	public Double getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}
	
	

	
	}

