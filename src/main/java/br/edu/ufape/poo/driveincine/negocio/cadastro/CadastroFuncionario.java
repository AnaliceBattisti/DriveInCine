package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoFuncionario;
import br.edu.ufape.poo.driveincine.negocio.basica.Endereco;
import br.edu.ufape.poo.driveincine.negocio.basica.Funcionario;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;

@Service
public class CadastroFuncionario implements InterfaceCadastroFuncionario  {
    @Autowired
    private InterfaceColecaoFuncionario colecaoFuncionario;

    
	public Funcionario cadastrarFuncionario(Funcionario entity) throws PreenchaTudoException, LoginNaoExclusivoException {
	    validarCamposObrigatorios(entity);
	    verificarLoginExclusivo(entity.getLogin());
	    return colecaoFuncionario.save(entity);
	}

	public void validarCamposObrigatorios(Funcionario entity) throws PreenchaTudoException {
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

	public void verificarLoginExclusivo(String login) throws LoginNaoExclusivoException {
	    if (colecaoFuncionario.findByLogin(login) != null) {
	        throw new LoginNaoExclusivoException(login);
	    }
	}


public void excluirFuncionario(Long id) {
    colecaoFuncionario.deleteById(id);
}


public List<Funcionario> listarTodosFuncionario() {
    return colecaoFuncionario.findAll();
}
}