package br.edu.ufape.poo.driveincine.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ufape.poo.driveincine.negocio.basica.Cliente;
import java.util.List;

@Repository
public interface InterfaceColecaoCliente extends JpaRepository<Cliente, Long>{

	List<Cliente> findByLogin(String login);

}
