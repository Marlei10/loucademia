package br.com.softblue.loucademia.domain.aluno;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.softblue.loucademia.application.util.StringUtils;

@Entity
@Table(name="ALUNO")
public class Aluno implements Serializable{
	
	
	@Id
	@Column(name="ID", nullable = false, length =8)
	private String matricula;
	
	
	@Column(name="NOME", nullable = false, length = 64)
	private String nome;
	
	@Enumerated
	@Column(name="SEXO", nullable = false,length = 1)
	private Sexo sexo;
	
	@Column(name="RG", nullable = false, length =10)
	private Integer rg;
	
	@Column(name="NASCIMENTO", nullable = false,length = 1)
	private LocalDate dataNascimento;
	
	@Enumerated
	@Column(name="SITUACAO", nullable = false, length =1)
	private Situacao situacao;
	
	@Column(name="EMAIL", nullable = false, length = 64 )
	private String email;
	
	@Embedded
	private Endereco endereco = new Endereco();
	
	@Embedded
	private Telefone telefone = new Telefone();
	
	public void gerarMatricula(String maxMatriucula) {
		Year year = Year.now();	
		
		if(maxMatriucula == null) {
			maxMatriucula = year + StringUtils.leftZeroes(0, 4);
		}
		
		int sequential = Integer.parseInt(maxMatriucula.substring(4));
		sequential++;
		
		this.matricula = year + StringUtils.leftZeroes(sequential, 4);
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public enum Sexo{
		Masculino,Feminino;
	}
	
	public enum Situacao{
		Ativo,Inativo,Pendente;
	}
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", sexo=" + sexo + ", rg=" + rg
				+ ", dataNascimento=" + dataNascimento + ", situacao=" + situacao + ", email=" + email + ", endereco="
				+ endereco + ", telefone=" + telefone + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	
}
