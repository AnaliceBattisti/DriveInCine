package br.edu.ufape.poo.driveincine.negocio.basica;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable

public class Endereco {	
	@Id
		private long id; 
		private String rua;
	    private String numero;
	    private String bairro;
	    private String cidade;
	    private String estado;
	    private String cep;

	    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
	        this.rua = rua;
	        this.numero = numero;
	        this.bairro = bairro;
	        this.cidade = cidade;
	        this.estado= estado;
	        this.cep = cep;
	    }

	 
	    public String getRua() {
	        return rua;
	    }

	    public String getNumero() {
	        return numero;
	    }

	    public String getBairro() {
	        return bairro;
	    }

	    public String getCidade() {
	        return cidade;
	    }


	    public String getCep() {
	        return cep;
	    }

		public String getEstado() {
			return estado;
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}
}
