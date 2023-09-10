package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoCliente;
import br.edu.ufape.poo.driveincine.negocio.basica.Cliente;
import br.edu.ufape.poo.driveincine.negocio.basica.Endereco;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;

@Service
public class CadastroCliente implements InterfaceCadastroCliente {
    @Autowired
    private InterfaceColecaoCliente colecaoCliente;

    public boolean verificarLoginExclusivo(String login) {
        List<Cliente> clientesComMesmoLogin = colecaoCliente.findByLogin(login);
        return clientesComMesmoLogin.isEmpty();
    }

    public Cliente cadastrarCliente(String nome, String rg, String cpf,
            String rua, String bairro, String cidade, String numero, String estado,String cep,
            String telefone, String dataNasc, String login, String senha)
            throws PreenchaTudoException, LoginNaoExclusivoException {
        
        if (nome == null || rg == null || cpf == null || rua == null || bairro == null ||
                cidade == null || numero == null || estado == null || cep == null|| telefone == null ||
                dataNasc == null || login == null || senha == null) {
            throw new PreenchaTudoException();
        }
        
        if (!verificarLoginExclusivo(login)) {
            throw new LoginNaoExclusivoException();
        }
      
        Endereco endereco = new Endereco(rua,numero, bairro,cidade, estado, cep);
        Cliente cliente = new Cliente(0, nome, rg, cpf, endereco, telefone, dataNasc, login, senha);

        return colecaoCliente.save(cliente);
    }
}
	
