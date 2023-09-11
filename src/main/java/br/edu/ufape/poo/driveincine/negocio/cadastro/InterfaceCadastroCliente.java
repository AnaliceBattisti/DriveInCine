package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;

import br.edu.ufape.poo.driveincine.negocio.basica.Cliente;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;

public interface InterfaceCadastroCliente {

	void verificarLoginExclusivo(String login) throws LoginNaoExclusivoException;

	Cliente cadastrarCliente(Cliente entity) throws PreenchaTudoException, LoginNaoExclusivoException;

	void validarCamposObrigatorios(Cliente entity) throws PreenchaTudoException;

	void excluirCliente(Long id);

	List<Cliente> listarTodosClientes();

}