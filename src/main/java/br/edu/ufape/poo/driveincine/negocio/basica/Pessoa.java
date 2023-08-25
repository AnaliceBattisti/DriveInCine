package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Pessoa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome;
    private String rg;
    private String cpf;
    private String endereco;
    private String telefone;
    private String dataNasc;
    
    public Pessoa ( long id,String nome, String rg, String cpf, String endereco, String telefone, String dataNasc) {
        this.nome = nome;
        this.id = id; 
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
   
    }

   //Get e Set
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

}
