


package br.edu.ufape.poo.driveincine.negocio.fachada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dto.IngressoDto;
import br.edu.ufape.poo.driveincine.negocio.basica.Cliente;
import br.edu.ufape.poo.driveincine.negocio.basica.Compra;
import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Funcionario;
import br.edu.ufape.poo.driveincine.negocio.basica.Gestor;
import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaFront;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaNormal;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroCliente;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroCompra;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroFilme;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroFuncionario;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroGestor;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroIngresso;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroSessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroVaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.CompraNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeJaExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.IngressoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.LoginNaoExclusivoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.PreenchaTudoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;

@Service
public class Fachada {

    @Autowired
    private InterfaceCadastroSessao cadastroSessao;

    @Autowired
    private InterfaceCadastroVaga cadastroVaga;
    
    @Autowired
    private InterfaceCadastroIngresso cadastroIngresso;
    
	@Autowired
	private InterfaceCadastroCompra cadastroCompra;
	
	@Autowired  InterfaceCadastroFilme cadastroFilme;
	
	@Autowired
	private InterfaceCadastroCliente cadastroCliente; 
	
	@Autowired
	private InterfaceCadastroFuncionario cadastroFuncionario; 
	
	@Autowired
	private InterfaceCadastroGestor cadastroGestor; 

    public Sessao procurarSessaoPeloId(long id) {
        return cadastroSessao.procurarSessaoPeloId(id);
    }

    public void excluirFuncionario(Long id) { 
    	cadastroFuncionario.excluirFuncionario(id);
    }

    public List<Funcionario> listarTodosFuncionario() {
        return cadastroFuncionario.listarTodosFuncionario();
    }
    
    public void excluirGestor(Long id) {
        cadastroGestor.excluirGestor(id);
    }

	public List<Gestor> listarTodosGestores() {
        return cadastroGestor.listarTodosGestores();
    }

	 public Cliente cadastrarCliente(Cliente entity) throws PreenchaTudoException, LoginNaoExclusivoException {
			return cadastroCliente.cadastrarCliente(entity);
		}
	 public Funcionario cadastrarFuncionario(Funcionario entity) throws PreenchaTudoException, LoginNaoExclusivoException {
			return cadastroFuncionario.cadastrarFuncionario(entity);
		}
	 
	 public Gestor cadastrarGestor(Gestor entity) throws PreenchaTudoException, LoginNaoExclusivoException {
			return cadastroGestor.cadastrarGestor(entity);
		}
	 
		public void verificarLoginExclusivoCliente(String login) throws LoginNaoExclusivoException {
	        cadastroCliente.verificarLoginExclusivo(login);
	    }
		public void verificarLoginExclusivoFuncionario(String login) throws LoginNaoExclusivoException {
		    cadastroFuncionario.verificarLoginExclusivo(login);
		}

		 public void verificarLoginExclusivoGestor(String login) throws LoginNaoExclusivoException {
		    cadastroGestor.verificarLoginExclusivo(login);
		    }
		 
		 public void excluirCliente(long id) {
		        cadastroCliente.excluirCliente(id);
		    }

		    public List<Cliente> listarTodosClientes() {
		        return cadastroCliente.listarTodosClientes();
		    }
	 
    public  List<Sessao> procurarSessoesPeloFilme(Filme filme) {
        return cadastroSessao.procurarSessoesPelofilme(filme);
    }

    public List<Sessao> listarTodasSessoes() {
        return cadastroSessao.listarTodasSessoes();
    }

    public void excluirSessao(long id) throws SessaoNaoExisteException {
        cadastroSessao.excluirSessao(id);
    }

    public List<Sessao> procurarSessoesPeloHorarioEData(float horario, String diaExibicao) throws SessaoNaoExisteException {
        return cadastroSessao.procurarSessoesPeloHorarioEData(horario, diaExibicao);
    }

    public Sessao salvarSessao(Sessao sessao) throws SessaoJaExistenteException, SessaoNaoExisteException {
        return cadastroSessao.salvarSessao(sessao);
    }

    public Vaga procurarVagaPeloId(long id) {
        return cadastroVaga.procurarVagaPeloId(id);
    }

    public Vaga salvarVaga(Vaga vaga) {
        return cadastroVaga.salvarVaga(vaga);
    }

    public void removerVaga(Long id) throws VagaNãoExisteException {
        cadastroVaga.removerVagaPorId(id);
    }

    public Vaga atualizarStatusVaga(long id, boolean ocupado) throws VagaOcupadaException {
        return cadastroVaga.atualizarStatusVaga(id, ocupado);
    }

    public List<Vaga> ListaVagas() {
		return cadastroVaga.ListaVagas();
	}
    
	public Ingresso salvarIngresso(Ingresso entity) {
		return cadastroIngresso.salvarIngresso(entity);
	}
	
	public List<Ingresso> listarIngressos() 
			throws IngressoNaoExisteException {
				List<Ingresso> ing = cadastroIngresso.listarIngressos();
				if (ing.size() == 0) {
					throw new IngressoNaoExisteException();
				}
				return ing;
			}

	public void removerIngressoId(Long id) throws IngressoNaoExisteException {
		cadastroIngresso.removerIngressoId(id);
	}

	public void removerIngresso(Ingresso entity) {
		cadastroIngresso.removerIngresso(entity);
	}
	
	public Ingresso procurarIngressoId(long id) throws IngressoNaoExisteException {
		return cadastroIngresso.procurarIngressoId(id);
	}
	
	public List<Compra> listarCompras() 
			throws CompraNaoExisteException {
				List<Compra> comp = cadastroCompra.listarCompras();
				if(comp.size() == 0) {
					throw new CompraNaoExisteException();
				}
				return comp;
		}

	public Compra salvarCompra(Compra entity) {
		return cadastroCompra.salvarCompra(entity);
	}

	public void removerCompraId(Long id) throws CompraNaoExisteException {
		cadastroCompra.removerCompraId(id);
	}

	public void removerCompra(Compra entity) {
		cadastroCompra.removerCompra(entity);
	}
	
	public Compra procurarCompraId(long id) throws CompraNaoExisteException {
		return cadastroCompra.procurarCompraId(id);
	}
	
	public List<Ingresso> comprarIngresso(IngressoDto ing) {
		Sessao sess = cadastroSessao.procurarSessaoPeloId(ing.getSessao());
		List<Vaga> vagas = new ArrayList<Vaga>();
		List<Ingresso> ingressosGerados = new ArrayList<Ingresso>();
		double valorTotal=0;
		
		for (int i=0; i<ing.getVagas().size();i++) {
			Vaga vagaTemp = cadastroVaga.procurarVagaPeloId(i);
			vagas.add(vagaTemp);
			valorTotal+=vagaTemp.getValor();
			vagaTemp.setOcupado(true);
		}
		
		//gerando compra
		Compra compra = new Compra();
		compra.setStatus("Aprovado");
		Date data = new Date();
		compra.setDataEmissao(data);
		compra.setValorTotal(valorTotal);
		
		//gerando Ingresso por vaga
		
		
		for (int i=0; i<vagas.size();i++) {
			Ingresso novo = new Ingresso();
			novo.setQrcode("1234");
			novo.setPlacaDoCarro(ing.getPlacaDoCarro());
			novo.setSessao(sess);
			novo.setCompra(compra);
			novo.setVaga(vagas.get(i));
			
			ingressosGerados.add(novo);
			cadastroIngresso.salvarIngresso(novo);
		}
		return ingressosGerados;
	}


    public List<Filme> listarFilmes() {
        return cadastroFilme.listarFilmes();
    }

    public Filme procurarFilmePeloTitulo(String titulo) {
        return cadastroFilme.procurarFilmePeloTitulo(titulo);
    }

    public Filme salvarFilme(Filme filme) throws FilmeJaExisteException {
        return cadastroFilme.salvarFilme(filme);
    }

    public void excluirFilme(String titulo) throws FilmeNaoExisteException {
        cadastroFilme.excluirFilme(titulo);
        
    }
    
    
    public Sessao criarVagasParaSessao(Sessao sessao) throws SessaoJaExistenteException {
        char[] colunas = {'A', 'B', 'C', 'D', 'E'};
        
        List<Vaga> vagas = new ArrayList<>();

        for (int linha = 1; linha <= 6; linha++) {
            for (char coluna : colunas) {
                Vaga vaga;
                if (coluna == 'A' || coluna == 'B') {
                    vaga = new VagaFront();
                } else {
                    vaga = new VagaNormal();
                }
                vaga.setLinha(linha);
                vaga.setColuna(String.valueOf(coluna));
                cadastroVaga.salvarVaga(vaga);
                vagas.add(vaga);
            }
        }
        
        sessao.setVagas(vagas); 
        return sessao;

    }
    
    public Sessao AddFilmeSessao(Sessao sessao ,String titulo) {
    	Filme filme = cadastroFilme.procurarFilmePeloTitulo(titulo);
    	sessao.setFilme(filme);
    	return sessao;
    }

    
}