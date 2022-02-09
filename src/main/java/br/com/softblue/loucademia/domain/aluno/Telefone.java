package br.com.softblue.loucademia.domain.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telefone  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="CELULAR_DDD", nullable= false, length = 2 )
	private Integer dddCelular;
	
	@Column(name="CELULAR_NUMERO", nullable = false, length = 9)
	private Integer numeroCelular;
	
	@Column(name="FIXO_DDD", nullable =true, length = 2)
	private Integer dddFixo;
	
	@Column (name="FIXO_NUMERO", nullable = true, length =9)
	private Integer numeroFixo;
	
	
	public int getDddCelular() {
		return dddCelular;
	}
	public void setDddCelular(int dddCelular) {
		this.dddCelular = dddCelular;
	}
	public int getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(int numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	public int getDddFixo() {
		return dddFixo;
	}
	public void setDddFixo(int dddFixo) {
		this.dddFixo = dddFixo;
	}
	public int getNumeroFixo() {
		return numeroFixo;
	}
	public void setNumeroFixo(int numeroFixo) {
		this.numeroFixo = numeroFixo;
	}
	@Override
	public String toString() {
		return "Telefone [dddCelular=" + dddCelular + ", numeroCelular=" + numeroCelular + ", dddFixo=" + dddFixo
				+ ", numeroFixo=" + numeroFixo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dddCelular;
		result = prime * result + dddFixo;
		result = prime * result + numeroCelular;
		result = prime * result + numeroFixo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (dddCelular != other.dddCelular)
			return false;
		if (dddFixo != other.dddFixo)
			return false;
		if (numeroCelular != other.numeroCelular)
			return false;
		if (numeroFixo != other.numeroFixo)
			return false;
		return true;
	}
	
	
	
	
	

}
