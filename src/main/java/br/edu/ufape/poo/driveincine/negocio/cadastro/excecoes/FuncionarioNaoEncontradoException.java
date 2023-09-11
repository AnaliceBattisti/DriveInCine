package br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes;

public class FuncionarioNaoEncontradoException extends Exception{
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontradoException() {
        super("Funcionário não encontrado.");
    }
}
