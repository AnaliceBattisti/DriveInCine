package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class LoginNaoExclusivoException extends Exception  {
	 public LoginNaoExclusivoException() {
		 super("Login já existe, tente novamente.");
	    }
}


