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

import br.com.dlcstudio.base.domain.Comentario;
import br.com.dlcstudio.base.services.ComentarioService;

@RestController
@RequestMapping(value="/comentarios")
public class ComentarioResource {
	

	@Autowired
	private ComentarioService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Comentario objDto) {
		
		Comentario obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{comentarioId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(
			@PathVariable Integer comentarioId
			) {
		service.delete(comentarioId);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/findByIdPostagem", method=RequestMethod.GET)
	public ResponseEntity<List<Comentario>> findByIdPostagem(
			@RequestParam(value="value") Integer id) {
		List<Comentario> list = service.findByPostagemId(id);
		return ResponseEntity.ok().body(list);
	}
}
