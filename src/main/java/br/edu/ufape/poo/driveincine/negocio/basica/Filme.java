package br.edu.ufape.poo.driveincine.negocio.basica;

	import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
	
	@Entity
	public class Filme {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String titulo;
		private float duracao;
		private int faixaEtaria;
		private String sinopse;
		private String diretor;
		private String capa;
		private String protagonistas;
		private String genero;
		
		@OneToMany
		@Cascade(CascadeType.ALL)
		private List<Sessao> sessoes;
	 
	    public Filme() {
	    	
	    }
	    
		
		public Filme(String titulo, float duracao, int faixaEtaria, String sinopse, String diretor, String capa,
				String protagonistas, String genero) {
			super();
			this.titulo = titulo;
			this.duracao = duracao;
			this.faixaEtaria = faixaEtaria;
			this.sinopse = sinopse;
			this.diretor = diretor;
			this.capa = capa;
			this.protagonistas = protagonistas;
			this.genero = genero;
		}

		public String getTitulo() {
			return titulo;
		}
		
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public float getDuracao() {
			return duracao;
		}
		public void setDuracao(float duracao) {
			this.duracao = duracao;
		}
		public int getFaixaEtaria() {
			return faixaEtaria;
		}
		public void setFaixaEtaria(int faixaEtaria) {
			this.faixaEtaria = faixaEtaria;
		}
		public String getSinopse() {
			return sinopse;
		}
		public void setSinopse(String sinopse) {
			this.sinopse = sinopse;
		}
		public String getDiretor() {
			return diretor;
		}
		public void setDiretor(String diretor) {
			this.diretor = diretor;
		}
		public String getCapa() {
			return capa;
		}
		public void setCapa(String capa) {
			this.capa = capa;
		}
		public String getProtagonistas() {
			return protagonistas;
		}
		public void setProtagonistas(String protagonistas) {
			this.protagonistas = protagonistas;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		public long getid() {
			return id;
		}
}
