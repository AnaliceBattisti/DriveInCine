package br.edu.ufape.poo.driveincine.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.fachada.Fachada;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SessaoController {

    @Autowired
    private Fachada fachada;

    @GetMapping("/sessao/{id}")
    public Sessao buscarSessaoPorId(@PathVariable Long id) {
        return fachada.procurarSessaoPeloId(id);
    }

    @GetMapping("/sessao")
    public List<Sessao> listarTodasSessoes() {
        return fachada.listarTodasSessoes();
    }
  
<<<<<<< HEAD
    @PostMapping("/sessao/{titulo}")
    public Sessao salvarSessao(@RequestBody Sessao sessao,@PathVariable String titulo) throws SessaoJaExistenteException {
    	Sessao sessaovagas = fachada.criarVagasParaSessao(sessao);
    	sessaovagas = fachada.AddFilmeSessao(sessaovagas,titulo );
=======
    @PostMapping("/savesessao/{id}")
    public Sessao salvarSessao(@RequestBody Sessao sessao,@PathVariable long id) throws SessaoJaExistenteException, SessaoNaoExisteException {
    	Sessao sessaovagas= fachada.criarVagasParaSessao(sessao);
    	sessaovagas = fachada.AddFilmeSessao(sessaovagas,id );
>>>>>>> 8153c2e28ecf3dc20f68a1a226a7e1172c41d9ea
    	Sessao sessaoSalva = fachada.salvarSessao(sessaovagas);
        return sessaoSalva;
    }
    

    @GetMapping("/sessao/horario-data/{horario}/{diaExibicao}")
    public List<Sessao> buscarSessoesPorHorarioEData(@PathVariable String horario, @PathVariable String diaExibicao) throws SessaoNaoExisteException {
        return fachada.procurarSessoesPeloHorarioEData(horario, diaExibicao);
    }
    
    @GetMapping("/sessao/vagas/{id}")
    public List<Vaga> procurarSessaoPelaVaga(@PathVariable long id) {
    	return fachada.procurarSessaoPelaVaga(id);
    }
  
    @GetMapping("/sessao/filme/{idFilme}")
    public List<Sessao> buscarSessoesPorFilme(@PathVariable Long idFilme) {
        return fachada.procurarSessoesPorIdFilme(idFilme);
    }

    
}
