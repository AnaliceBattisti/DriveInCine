package br.edu.ufape.poo.driveincine.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.driveincine.dto.IngressoDto;
import br.edu.ufape.poo.driveincine.negocio.basica.Ingresso;
import br.edu.ufape.poo.driveincine.negocio.cadastro.excecoes.IngressoNaoExisteException;
import br.edu.ufape.poo.driveincine.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/v1")
public class IngressoController {
	
	@Autowired
	private Fachada fachada;
	
	@GetMapping("/ingresso")
	public List<Ingresso> listarIngressos() throws IngressoNaoExisteException {
		return fachada.listarIngressos();
	}
	
	@PostMapping("/ingresso")
	public String comprarIngresso(@RequestBody IngressoDto ing) {
		fachada.comprarIngresso(ing);
		
		return "ok";
	}
	
	@PatchMapping("/ingresso/{id}")
	public Ingresso atualizarIngresso(@PathVariable long id, @RequestBody Ingresso ing) {
		ing.setId(id);
		return fachada.salvarIngresso(ing);
	}
	
	@DeleteMapping("/ingresso/{id}")
	public String apagarIngresso(@PathVariable long id) throws IngressoNaoExisteException {
		fachada.removerIngressoId(id);
		return "Removido com sucesso";
	}

}