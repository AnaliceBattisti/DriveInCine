package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.driveincine.negocio.basica.Gestor;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;

public interface InterfaceCadastroGestor {

	Gestor cadastrarGestor(Gestor entity) throws PreenchaTudoException, LoginNaoExclusivoException;

	void validarCamposObrigatorios(Gestor entity) throws PreenchaTudoException;

	void verificarLoginExclusivo(String login) throws LoginNaoExclusivoException;

	void excluirGestor(Long id);

	List<Gestor> listarTodosGestores();

}