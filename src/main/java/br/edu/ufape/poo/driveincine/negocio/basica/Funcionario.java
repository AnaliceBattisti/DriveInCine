package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Funcionario extends Pessoa {
	  	private String cargo;
	    private boolean ativo;
	    private String login;
	    private String senha;

	    public Funcionario(String nome, String rg, String cpf, Endereco endereco, String telefone, String dataNasc,
	    String cargo, String login, String senha, long id) {
	        super(id, rg, cpf, telefone, endereco, dataNasc, nome);
	        this.cargo = cargo;
	        this.ativo = true; 
	        this.login = login;
	        this.senha = senha;
	    }

	    //Get e Set
	    public String getCargo() {
	        return cargo;
	    }

	    public void setCargo(String cargo) {
	        this.cargo = cargo;
	    }

	    public boolean isAtivo() {
	        return ativo;
	    }

	    public void setAtivo(boolean ativo) {
	        this.ativo = ativo;
	    }

	    public String getLogin() {
	        return login;
	    }

	    public void setLogin(String login) {
	        this.login = login;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }
}
