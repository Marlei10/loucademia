package br.com.softblue.loucademia.domain.aluno;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ESTADO")
public class Estado implements Serializable {
	
	
	@Id
	@Column(name="sigla", nullable = false,length =2)
	private String sigla;
	@Column(name="NOME", nullable = false, length =30)
	private String nome;
	
	//Setters
	public void setSigla(String sigla)
	{
		this.sigla = sigla;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	//Getters
	public String getSigla()
	{
		return sigla;
	}
	
	public String getNome()
	{
		return nome;
	}

	@Override
	public String toString() {
		return "Estado [sigla=" + sigla + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
		Estado other = (Estado) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
	
	
	
}
