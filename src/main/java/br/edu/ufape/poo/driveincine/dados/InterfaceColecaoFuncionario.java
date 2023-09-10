package br.edu.ufape.poo.driveincine.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ufape.poo.driveincine.negocio.basica.Funcionario;

@Repository
public interface InterfaceColecaoFuncionario extends JpaRepository<Funcionario, Long>{

	List<Funcionario> findByLogin(String login);
}
