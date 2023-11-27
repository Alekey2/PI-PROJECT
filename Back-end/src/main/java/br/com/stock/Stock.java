package br.com.stock;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity (name = "Estoque")
public class Stock implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)

	@Column (name = "ID")
	int id;
	
	@Column (name = "Nome")
	String nome;
	
	@Column (name = "Preco")
	double preco;
	
	@Column (name = "Custo")
	double custo;
	
	@Column (name = "Descricao")
	String descricao;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public Stock() {
		super();
	}

	public Stock(int id, String nome, double preco, double custo, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.custo = custo;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", nome=" + nome + ", preco=" + preco + ", custo=" + custo + ", descricao="
				+ descricao + ", getId()=" + getId() + ", getNome()=" + getNome() + ", getPreco()=" + getPreco()
				+ ", getCusto()=" + getCusto() + ", getDescricao()=" + getDescricao() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
