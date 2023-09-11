package br.edu.ufape.poo.driveincine.dados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;

@SpringBootTest
class InterfaceColecaoIngressoTest {
	
	@Autowired
	private InterfaceColecaoIngresso colecaoIngresso;

	@Test
	void CadastrarIngressoTest() {
		
		long qtdIngressos = colecaoIngresso.count();
		Ingresso ing = new Ingresso("abcd", 16);
		
		colecaoIngresso.save(ing);
		long qtdIngressosAposCadastro = colecaoIngresso.count();
		
		assertEquals(qtdIngressos + 1, qtdIngressosAposCadastro);
		
	}

}
