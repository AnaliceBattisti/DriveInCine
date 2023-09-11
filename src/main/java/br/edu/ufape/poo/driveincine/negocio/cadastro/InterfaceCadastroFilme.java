package br.edu.ufape.poo.driveincine.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeJaExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeNaoExisteException;

public interface InterfaceCadastroFilme {

    List<Filme> listarFilmes();

	Filme procurarFilmePeloId(long id);

    Filme procurarFilmePeloTitulo(String titulo);

    Filme salvarFilme(Filme filme) throws FilmeJaExisteException;
    void excluirFilme(String titulo) throws FilmeNaoExisteException;


}
