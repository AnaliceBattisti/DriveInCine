package br.edu.ufape.poo.driveincine.negocio.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoSessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaFront;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaNormal;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroSessao implements InterfaceCadastroSessao {
	
    @Autowired
    private InterfaceColecaoSessao colecaoSessao;
    
    @Autowired
    private CadastroVaga cadastroVaga; 

    public Sessao procurarSessaoPeloId(long id) {
        return colecaoSessao.findById(id).orElse(null);
    }

    public List<Sessao> listarTodasSessoes() {
        return colecaoSessao.findAll();
    }
    
    public void excluirSessao(long Id) throws SessaoNaoExisteException {
        Sessao sessao = procurarSessaoPeloId(Id);
        
        if (sessao != null) {
            colecaoSessao.delete(sessao);
        } else {
            throw new SessaoNaoExisteException();
        }
    }

    public List<Sessao> procurarSessoesPeloHorarioEData(float horario, String diaExibicao) throws SessaoNaoExisteException {
    	List<Sessao> temSessao = colecaoSessao.findByHorarioAndDiaExibicao(horario, diaExibicao);
    	if(temSessao.isEmpty()) {
    		throw new SessaoNaoExisteException();
    	}
        return temSessao;
    }
    
//    public List<Sessao> procurarSessoesPelofilme(Filme filme) {
//        return colecaoSessao.findByFilme(filme);
//    }
   
    public Sessao salvarSessao(Sessao sessao) throws SessaoJaExistenteException, SessaoNaoExisteException {
        List<Sessao> sessoesExistentes = procurarSessoesPeloHorarioEData(sessao.getHorario(), sessao.getDiaExibicao());
        if (!sessoesExistentes.isEmpty()) {
            throw new SessaoJaExistenteException(sessao.getHorario(), sessao.getDiaExibicao());
        }

        Sessao novaSessao = colecaoSessao.save(sessao);
        return novaSessao;
    }
    }
    
    
