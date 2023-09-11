package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.driveincine.negocio.basica.Funcionario;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;

public interface InterfaceCadastroFuncionario {

	Funcionario cadastrarFuncionario(Funcionario entity) throws PreenchaTudoException, LoginNaoExclusivoException;

	void validarCamposObrigatorios(Funcionario entity) throws PreenchaTudoException;

	void verificarLoginExclusivo(String login) throws LoginNaoExclusivoException;

	void excluirFuncionario(Long id);

	List<Funcionario> listarTodosFuncionario();

}