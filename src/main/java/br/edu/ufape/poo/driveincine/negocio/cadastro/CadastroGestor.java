package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoGestor;
import br.edu.ufape.poo.driveincine.negocio.basica.Endereco;
import br.edu.ufape.poo.driveincine.negocio.basica.Gestor;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;

	@Service
	public class CadastroGestor implements InterfaceCadastroGestor   {
	    @Autowired
	    private InterfaceColecaoGestor colecaoGestor;
	    
	    
	    public Gestor cadastrarGestor(Gestor entity) throws PreenchaTudoException, LoginNaoExclusivoException {
	        validarCamposObrigatorios(entity);
	        verificarLoginExclusivo(entity.getLogin());
	        return colecaoGestor.save(entity);
	    }

	    public void validarCamposObrigatorios(Gestor entity) throws PreenchaTudoException {
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
	        if (colecaoGestor.findByLogin(login) != null) {
	            throw new LoginNaoExclusivoException(login);
	        }
	    }
	    
	  
		public void excluirGestor(Long id) {
	        colecaoGestor.deleteById(id);
	    }

		public List<Gestor> listarTodosGestores() {
	        return colecaoGestor.findAll();
	    }
	}
