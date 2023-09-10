package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Cliente extends Pessoa{
			@PrimaryKeyJoinColumn(name = "idPessoa")
		private String login;
		private String senha;
		public Cliente(long id, String nome, String rg, String cpf, Endereco endereco, String telefone, String dataNasc, String login, String senha) {
		super(id, nome, rg, cpf, endereco, telefone, dataNasc);
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
		}}
	