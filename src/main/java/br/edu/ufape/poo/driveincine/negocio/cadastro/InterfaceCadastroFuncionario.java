package br.edu.ufape.poo.driveincine.negocio.cadastro;

import br.edu.ufape.poo.driveincine.negocio.basica.Funcionario;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;

public interface InterfaceCadastroFuncionario {
	    boolean verificarLoginExclusivo(String login)
	            throws LoginNaoExclusivoException;

	    Funcionario cadastrarFuncionario(String nome, String rg, String cpf,
	            String rua, String bairro, String cidade, String numero, String estado, String cep,
	            String telefone, String dataNasc, String cargo, String login, String senha)
	            throws PreenchaTudoException, LoginNaoExclusivoException;
}
