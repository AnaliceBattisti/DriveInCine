package br.edu.ufape.poo.driveincine.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;

@Repository
public interface InterfaceColecaoSessao extends JpaRepository<Sessao, Long> {

    List<Sessao> findByHorarioAndDiaExibicao(String horario, String diaExibicao);
   
    List<Sessao> findByDiaExibicao(String diaExibicao);
    List<Sessao> findByHorario(String horario);

	List<Sessao> findByFilme_Id(long idFilme);
	
}