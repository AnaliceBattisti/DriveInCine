package br.edu.ufape.poo.driveincine.negocio.cadastro;

import br.edu.ufape.poo.driveincine.negocio.basica.Cliente;
import br.edu.ufape.poo.driveincine.negocio.basica.Endereco;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;

public interface InterfaceCadastroCliente {

    Cliente cadastrarCliente(String nome, String rg, String cpf, Endereco endereco, String telefone, String dataNasc, String login, String senha)
            throws PreenchaTudoException, LoginNaoExclusivoException;

}
