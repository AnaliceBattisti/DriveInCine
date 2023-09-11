package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class SessaoJaExistenteException extends Exception {

    public SessaoJaExistenteException(String horario, String diaExibicao) {
        super("Sessao já existe para o horario " + horario + " e data de exibicao " + diaExibicao);
    }
}
