package br.edu.ufape.poo.driveincine.negocio.cadastro;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoGestor;
import br.edu.ufape.poo.driveincine.negocio.basica.Endereco;
import br.edu.ufape.poo.driveincine.negocio.basica.Gestor;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;

	@Service
	public class CadastroGestor implements InterfaceCadastroGestor {
	    @Autowired
	    private InterfaceColecaoGestor colecaoGestor;

	    public boolean verificarLoginExclusivo(String login) {
	        List<Gestor> gestoresComMesmoLogin = colecaoGestor.findByLogin(login);
	        return gestoresComMesmoLogin.isEmpty();
	    }

	    public Gestor cadastrarGestor(String nome, String rg, String cpf,
	            String rua, String bairro, String cidade, String numero, String estado, String cep,
	            String telefone, String dataNasc, String cargo, String login, String senha)
	            throws PreenchaTudoException, LoginNaoExclusivoException {

	        if (nome == null || rg == null || cpf == null || rua == null || bairro == null ||
	                cidade == null || numero == null || estado == null || cep == null || telefone == null ||
	                dataNasc == null || cargo == null || login == null || senha == null) {
	            throw new PreenchaTudoException();
	        }

	        if (!verificarLoginExclusivo(login)) {
	            throw new LoginNaoExclusivoException();
	        }

	        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
	        Gestor gestor = new Gestor(nome, rg, cpf, endereco, telefone, dataNasc, cargo, login, senha, 0);

	        return colecaoGestor.save(gestor);
	    }
	}



