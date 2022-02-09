package br.com.softblue.loucademia.application.service;

import br.com.softblue.loucademia.domain.aluno.Aluno;
import br.com.softblue.loucademia.domain.aluno.AlunoRepository;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.softblue.loucademia.application.util.StringUtils;
import br.com.softblue.loucademia.application.util.ValidationException;
import br.com.softblue.loucademia.domain.acesso.Acesso;
import br.com.softblue.loucademia.domain.acesso.AcessoRepository;
import br.com.softblue.loucademia.domain.acesso.TipoAcesso;
import br.com.softblue.loucademia.domain.aluno.Aluno;
import br.com.softblue.loucademia.domain.aluno.AlunoRepository;

@Stateless
public class AcessoService {

	@EJB
	private AcessoRepository acessoRepository;
	
	@EJB
	private AlunoRepository alunoRepository;
	
	public TipoAcesso registrarAcesso(String matricula, Integer rg) throws ValidationException {
		if(StringUtils.isEmpty(matricula) && rg==null) {
			throw new ValidationException("É preciso fornecer a matrícula ou o RG do aluno");
		}
		
		Aluno aluno;
		if(StringUtils.isEmpty(matricula)) {
			aluno = alunoRepository.findByRG(rg);
		}else {
			aluno = alunoRepository.findByMatricyla(matricula);
		}
		if(aluno ==null) {
			throw new ValidationException("Aluno não foi encontrado");
		}
		
		Acesso ultimoAcesso = acessoRepository.findUltimoAcesso(aluno);
		TipoAcesso tipoAcesso = null;
		
		if(ultimoAcesso == null || ultimoAcesso.isEntradaSaidaPreenchidas()) {
			ultimoAcesso = new Acesso();
			ultimoAcesso.setAluno(aluno);
			ultimoAcesso.registrarAcesso();
			tipoAcesso = ultimoAcesso.registrarAcesso();
			acessoRepository.store(ultimoAcesso);
		} else {
			ultimoAcesso.registrarAcesso();
		}
		return tipoAcesso;
		
	}
}
