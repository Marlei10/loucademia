package br.com.softblue.loucademia.interfaces.aluno.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.softblue.loucademia.application.service.AlunoService;
import br.com.softblue.loucademia.application.util.ValidationException;
import br.com.softblue.loucademia.domain.aluno.Aluno;

@Named
@SessionScoped
public class PesquisaAlunoBean implements Serializable{
	
	@EJB
	private AlunoService alunoService;
	
	@Inject
	private FacesContext facesContext;
	private String matricula;
	private String nome;
	private Integer rg;
	private Integer telefone;
	
	private List<Aluno> alunos;
	
	//Métodos
	public String pesquisar() {
		try {
			alunos = alunoService.listAluno(matricula, nome, rg, telefone);
		}catch(ValidationException e) {
			facesContext.addMessage(null, new FacesMessage(e.getMessage()));
		}
		return null;
	}
	
	public String excluir(String matricula) {
		alunoService.delete(matricula);
		return pesquisar();
	}
	
	
	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}
	
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
	//getters
	public String getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getRg() {
		return rg;
	}
	
	public Integer getTelefone() {
		return telefone;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	
	
	
}
