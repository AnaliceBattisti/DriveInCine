package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class LoginNaoExclusivoException extends Exception  {
	private static final long serialVersionUID = 1L;

	public LoginNaoExclusivoException(String email) {
		 super("Login já existe, tente novamente.");
	    }

}

