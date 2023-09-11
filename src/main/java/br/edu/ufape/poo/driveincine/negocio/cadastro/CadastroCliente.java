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
public class CadastroCliente implements InterfaceCadastroCliente{
    @Autowired
    private InterfaceColecaoCliente colecaoCliente;

	public void verificarLoginExclusivo(String login) throws LoginNaoExclusivoException {
        if (colecaoCliente.findByLogin(login) != null) {
            throw new LoginNaoExclusivoException(login);
        }
    }
    
	public Cliente cadastrarCliente(Cliente entity) throws PreenchaTudoException, LoginNaoExclusivoException {
        validarCamposObrigatorios(entity);
        verificarLoginExclusivo(entity.getLogin()); 
        return colecaoCliente.save(entity);
    }

   
	public void validarCamposObrigatorios(Cliente entity) throws PreenchaTudoException {
        if (entity.getNome() == null || entity.getNome().isEmpty() ||
            entity.getRg() == null || entity.getRg().isEmpty() ||
            entity.getCpf() == null || entity.getCpf().isEmpty() ||
            entity.getEndereco() == null ||
            entity.getTelefone() == null || entity.getTelefone().isEmpty() ||
            entity.getDataNasc() == null || entity.getDataNasc().isEmpty() ||
            entity.getLogin() == null || entity.getLogin().isEmpty() ||
            entity.getSenha() == null || entity.getSenha().isEmpty()) {
            throw new PreenchaTudoException(); 
        }
    }
    

	public void excluirCliente(Long id) {
        colecaoCliente.deleteById(id);
    }

    
	public List<Cliente> listarTodosClientes() {
        return colecaoCliente.findAll();
    }
}
