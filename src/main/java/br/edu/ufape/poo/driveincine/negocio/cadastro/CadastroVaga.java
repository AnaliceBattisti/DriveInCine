package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dados.InterfaceColecaoVaga;
import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaFront;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaNormal;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;

@Service
public class CadastroVaga implements InterfaceCadastroVaga {
	
	

	@Autowired
    private InterfaceColecaoVaga colecaoVaga;
	
    public List<Vaga> ListaVagas() {
		return colecaoVaga.findAll();
	}

    
    public Vaga procurarVagaPeloId(long id) {
        return colecaoVaga.findById(id).orElse(null);
    }

    public void removerVagaPorId(Long id) throws VagaNãoExisteException {
        if (!colecaoVaga.existsById(id)) {
            throw new VagaNãoExisteException();
        }
        colecaoVaga.deleteById(id);
    }
    
    
    public Vaga atualizarStatusVaga(Long id, boolean ocupado) throws VagaOcupadaException {
        Vaga vaga = colecaoVaga.findById(id).orElse(null);
        if (vaga == null) {
        }
        
        if (vaga.isOcupado() && ocupado) {
            throw new VagaOcupadaException(id);
        }
        
        vaga.setOcupado(ocupado);
        colecaoVaga.save(vaga);
        
        return vaga;
    }
    
    
    public Vaga salvarVaga(Vaga vaga) {
        return colecaoVaga.save(vaga);
    }
    

}
    
    
    

