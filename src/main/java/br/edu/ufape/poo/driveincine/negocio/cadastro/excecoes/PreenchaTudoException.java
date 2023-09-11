package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class PreenchaTudoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PreenchaTudoException() {
    super("Todos os campos obrigatórios devem ser preenchidos.");
    }
}
