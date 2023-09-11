package br.edu.ufape.poo.driveincine.dados;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;

@SpringBootTest
public class InterfaceColecaoSessaoTest {

    @Autowired
    private InterfaceColecaoSessao colecaoSessao;

    @Test
    public void cadastrarSessaoTest() {
        long qtdSessoes = colecaoSessao.count();
        Sessao sessao = new Sessao(0, "18:30", "20-10-2023");

        colecaoSessao.save(sessao);
        long qtdSessoesAposCadastro = colecaoSessao.count();

        assertEquals(qtdSessoes + 1, qtdSessoesAposCadastro);
    }
}
