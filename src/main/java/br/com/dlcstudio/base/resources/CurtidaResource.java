package br.com.dlcstudio.base.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dlcstudio.base.domain.Curtida;
import br.com.dlcstudio.base.domain.CurtidaPK;
import br.com.dlcstudio.base.services.CurtidaService;

@RestController
@RequestMapping(value="/curtidas")
public class CurtidaResource {
	
	@Autowired
	private CurtidaService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Curtida objDto) {
		
		Curtida obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{usuarioId}/{postagemId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(
			@PathVariable Integer usuarioId, 
			@PathVariable Integer postagemId
			) {
		CurtidaPK id = new CurtidaPK(usuarioId, postagemId);
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/findByIdPostagem", method=RequestMethod.GET)
	public ResponseEntity<List<Curtida>> findByIdPostagem(
			@RequestParam(value="value") Integer id) {
		List<Curtida> list = service.findByIdPostagemId(id);
		return ResponseEntity.ok().body(list);
	}
}
