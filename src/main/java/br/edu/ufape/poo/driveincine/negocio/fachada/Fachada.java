package br.edu.ufape.poo.driveincine.negocio.fachada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.driveincine.dto.IngressoDto;
import br.edu.ufape.poo.driveincine.negocio.basica.Filme;
import br.edu.ufape.poo.driveincine.negocio.basica.Compra;
import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
import br.edu.ufape.poo.driveincine.negocio.basica.Sessao;
import br.edu.ufape.poo.driveincine.negocio.basica.Usuario;
import br.edu.ufape.poo.driveincine.negocio.basica.Vaga;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaFront;
import br.edu.ufape.poo.driveincine.negocio.basica.VagaNormal;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroIngresso;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroSessao;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroUsuario;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroVaga;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroCompra;
import br.edu.ufape.poo.driveincine.negocio.cadastro.InterfaceCadastroFilme;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoJaExistenteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.SessaoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.UsuarioDuplicadoException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.UsuarioNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaNãoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.VagaOcupadaException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.CompraNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeJaExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.FilmeNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.IngressoNaoExisteException;

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
	
	@Autowired InterfaceCadastroFilme cadastroFilme;
	
	@Autowired InterfaceCadastroUsuario cadastroUsuario;
	

    public Sessao procurarSessaoPeloId(long id) {
        return cadastroSessao.procurarSessaoPeloId(id);
    }

    public List <Vaga> listarVagasPorSessao(long idSessao){
    	Sessao sessao = cadastroSessao.procurarSessaoPeloId(idSessao);
    	 List<Vaga> vagas = sessao.getVagas();
   	 return vagas ;
   }
    
    
    public void deleteFilme(long id) {
    	cadastroFilme.deleteFilme(id);
    }

    public List<Sessao> listarTodasSessoes() {
        return cadastroSessao.listarTodasSessoes();
    }

    public void excluirSessao(long id) throws SessaoNaoExisteException {
        cadastroSessao.excluirSessao(id);
    }

    public List<Sessao> procurarSessoesPeloHorarioEData(String horario, String diaExibicao){
        return cadastroSessao.procurarSessoesPeloHorarioEData(horario, diaExibicao);
    }

    public Sessao salvarSessao(Sessao sessao) throws SessaoJaExistenteException {
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
		
		for (int i=0; i<ing.getVagas().length;i++) {
			Vaga vagaTemp = cadastroVaga.procurarVagaPeloId(ing.getVagas()[i]);
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
			novo.setSessao(sess);
			novo.setCompra(compra);
			novo.setVaga(vagas.get(i));
			
			ingressosGerados.add(novo);
			cadastroIngresso.salvarIngresso(novo);
		}
		return ingressosGerados;
	}
	   public Filme ProcurarFilmepeloId(Long id) {
			return cadastroFilme.procurarFilmePeloId(id);
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
    
    public Sessao AddFilmeSessao(Sessao sessao ,long id) {
    	Filme filme = cadastroFilme.procurarFilmePeloId(id);
    	sessao.setFilme(filme);
    	
    	return sessao;
    }

    public List<Vaga> procurarSessaoPelaVaga(long id) {
    	Sessao sessao = cadastroSessao.procurarSessaoPeloId(id);
    	List<Vaga> vagas = sessao.getVagas();
		return vagas;
    	
    }
    
    public long PegarIdFilme(String titulo) {
    	Filme filme = cadastroFilme.procurarFilmePeloTitulo(titulo);
    	long id = filme.getid();
    	return(id);
    }
    
    public List<Sessao> procurarSessoesPorIdFilme(long idFilme) {
        return cadastroSessao.procurarSessoesPorIdFilme(idFilme);
           
    }
    public Usuario procurarUsuarioEmail(String email) throws UsuarioNaoExisteException {
        return cadastroUsuario.procurarUsuarioEmail(email);
    }

    public Usuario salvarUsuario(Usuario entity) throws UsuarioDuplicadoException {
        return cadastroUsuario.salvarUsuario(entity);
    }

    public List<Usuario> listarUsuarios() {
        return cadastroUsuario.listarUsuarios();
    }

    public boolean verificarExistenciaUsuarioId(Long id) {
        return cadastroUsuario.verificarExistenciaUsuarioId(id);
    }

    public Usuario localizarUsuarioId(Long id) {
        return cadastroUsuario.localizarUsuarioId(id);
    }

    public void removerUsuarioEmail(String email) throws UsuarioNaoExisteException {
        cadastroUsuario.removerUsuarioEmail(email);
    }
    

    public List<Ingresso> ListarIngressoDoUsuario(long idUsuario) throws UsuarioNaoExisteException {
        Usuario usuario = cadastroUsuario.localizarUsuarioId(idUsuario);
        if (usuario == null) {
            throw new UsuarioNaoExisteException(null);
        }
        
        return usuario.getIngressos();
    }

	}
	

	
    
    
    
