package br.edu.ufape.poo.driveincine.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeJaExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.fachada.Fachada;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FilmeController {

    @Autowired
    private Fachada fachada;

    @GetMapping ("/filme")
    public List<Filme> listarFilmes() {
        return fachada.listarFilmes();
    }

    @GetMapping("/filmeid/{titulo}")
    public Long pegarid(@PathVariable String titulo) {
        return fachada.PegarIdFilme(titulo);
    }

    @GetMapping("/filme/{titulo}")
    public Filme procurarFilmePeloTitulo(@PathVariable String titulo) {
        return fachada.procurarFilmePeloTitulo(titulo);
    }

    @PostMapping("/filme")
    public Filme salvarFilme(@RequestBody Filme filme) throws FilmeJaExisteException {
        return fachada.salvarFilme(filme);
    }

    @DeleteMapping("/filme")
    public void excluirFilmePorEntidade(@RequestBody String titulo) throws FilmeNaoExisteException {
    	fachada.excluirFilme(titulo);
    }
    
    
}