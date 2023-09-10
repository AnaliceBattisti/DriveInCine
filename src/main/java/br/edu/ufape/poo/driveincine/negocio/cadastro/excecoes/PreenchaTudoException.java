package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class PreenchaTudoException extends Exception {

    public PreenchaTudoException() {
    super("Todos os campos obrigatórios devem ser preenchidos.");
    }
}
