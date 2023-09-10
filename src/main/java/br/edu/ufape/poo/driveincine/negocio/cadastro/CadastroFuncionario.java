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
public class CadastroFuncionario {
    @Autowired
    private InterfaceColecaoFuncionario colecaoFuncionario;

    public boolean verificarLoginExclusivo(String login) {
        List<Funcionario> funcionariosComMesmoLogin = colecaoFuncionario.findByLogin(login);
        return funcionariosComMesmoLogin.isEmpty();
    }

    public Funcionario cadastrarFuncionario(String nome, String rg, String cpf,
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
        Funcionario funcionario = new Funcionario(nome, rg, cpf, endereco, telefone, dataNasc, cargo, login, senha, 0);

        return colecaoFuncionario.save(funcionario);
    }
}
