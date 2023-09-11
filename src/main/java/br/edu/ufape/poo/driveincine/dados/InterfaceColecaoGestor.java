package br.edu.ufape.poo.driveincine.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ufape.poo.driveincine.negocio.basica.Gestor;

@Repository
public interface InterfaceColecaoGestor extends JpaRepository<Gestor, Long>{
	List<Gestor> findByLogin(String login);
	
	
}