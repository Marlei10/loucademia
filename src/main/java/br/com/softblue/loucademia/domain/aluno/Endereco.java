package br.com.softblue.loucademia.domain.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 @Embeddable
public class Endereco implements Serializable{
	@Column(name="RUA", nullable = false, length = 128)
	private String rua;
	
	@Column(name="NUMERO", nullable = true, length = 6)
	private int numero;
	
	@Column(name="COMPLEMENTO", nullable = true, length = 32)
	private String complemento;
	
	@Column(name="CIDADE", nullable = false, length = 64)
	private String cidade;
	
	@Column(name="CEP", nullable = false,length =8)
	private int cep;
	
	@ManyToOne
	
	@JoinColumn(name="ESTADO", nullable = false)
	private Estado estado = new Estado();
	
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", complento=" + complemento + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + "]";
	}
	
	
	

}
