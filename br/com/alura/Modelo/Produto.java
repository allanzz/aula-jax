package br.com.alura.Modelo;

public class Produto {
	private String nome;
	private Double preco;
	public Produto(String nome,double preco)
	{
		this.nome = nome;
		this.preco =preco;
	}
	public Produto() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Nome:"+nome+"\nPre�o:"+this.preco+"\n";
	}

}
