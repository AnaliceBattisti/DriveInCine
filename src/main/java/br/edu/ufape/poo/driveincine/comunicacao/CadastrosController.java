package br.edu.ufape.poo.driveincine.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.poo.driveincine.negocio.basica.Cliente;
import br.edu.ufape.poo.driveincine.negocio.basica.Funcionario;
import br.edu.ufape.poo.driveincine.negocio.basica.Gestor;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;
import br.edu.ufape.poo.driveincine.negocio.fachada.Fachada;
import br.edu.ufape.poo.driveincine.negocio.cadastro.CadastroCliente;
import br.edu.ufape.poo.driveincine.negocio.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.driveincine.negocio.cadastro.CadastroGestor;

@RestController
@RequestMapping("/api/v1/cadastro")
public class CadastrosController {
    @Autowired
	private Fachada fachada;
    

	@PostMapping("/cadastrar/usuario")
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) throws PreenchaTudoException, LoginNaoExclusivoException  {
			return fachada.cadastrarCliente(cliente);
	}
  
    @PostMapping("/cadastrar/funcionario")
    public Funcionario cadastrarFuncionario(@RequestBody Funcionario funcionario) throws PreenchaTudoException, LoginNaoExclusivoException{
		return fachada.cadastrarFuncionario(funcionario);
    }
    
    @PostMapping("/cadastrar/gestor")
    public Gestor cadastrarGestor(@RequestBody Gestor gestor) throws PreenchaTudoException, LoginNaoExclusivoException{
		return fachada.cadastrarGestor(gestor);
    }
      
    @GetMapping("/listar/cliente")
    public List<Cliente> listarClientes() {
        return fachada.listarTodosClientes();
    }

    @DeleteMapping("/excluir/cliente/{id}")
    public void excluirCliente(@PathVariable Long id) {
        fachada.excluirCliente(id);
    }
    
@GetMapping("/listar/funcionario")
public List<Funcionario> listarFuncionario() {
    return fachada.listarTodosFuncionario();
}

@DeleteMapping("/excluir/funcionario/{id}")
public void excluirFuncionario(@PathVariable Long id) {
    fachada.excluirFuncionario(id);
}

@GetMapping("/listar/gestor")
public List<Gestor> listarGestor() {
    return fachada.listarTodosGestores();
}

@DeleteMapping("/excluir/gestor/{id}")
public void excluirGestor(@PathVariable Long id) {
    fachada.excluirGestor(id);
}
}
