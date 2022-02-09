package br.com.softblue.loucademia.application.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.softblue.loucademia.application.util.StringUtils;
import br.com.softblue.loucademia.application.util.Validation;
import br.com.softblue.loucademia.application.util.ValidationException;
import br.com.softblue.loucademia.domain.aluno.Aluno;
import br.com.softblue.loucademia.domain.aluno.AlunoRepository;


@Stateless
public class AlunoService {
	
	@EJB
	private AlunoRepository alunoRepository;
	
	public void createOrUpdate(Aluno aluno) throws ValidationException {
		if(StringUtils.isEmpty(aluno.getMatricula())) {
			create(aluno);
		}else {
			update(aluno);
		}
	}
	
	private void create(Aluno aluno) throws ValidationException {
		Validation.assertNotEmpty(aluno);
		
		String maxMatricula = alunoRepository.getMaxMatriculaAno();
		aluno.gerarMatricula(maxMatricula);
		alunoRepository.store(aluno);
		
	}
	
	private void update(Aluno aluno) throws ValidationException {
		Validation.assertNotEmpty(aluno);
		Validation.assertNotEmpty(aluno.getMatricula());
		alunoRepository.update(aluno);
	}
	public void delete(String matricula) {
		alunoRepository.delete(matricula);
	}
	
	public Aluno findByMatricula(String matricula) {
		return alunoRepository.findByMatricyla(matricula);
	}
	
	public List<Aluno> listAluno (String matricula, String nome, Integer rg, Integer telefone) throws ValidationException{
		if( StringUtils.isEmpty(matricula) && StringUtils.isEmpty(nome)	&& rg == null && telefone == null) {
			throw new ValidationException("Pelo menos um critério de busca deve ser preenchido");
		}
		return alunoRepository.listALunos(matricula, nome, rg, telefone);
	}
	
	
	
}

