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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dlcstudio.base.domain.Postagem;
import br.com.dlcstudio.base.services.PostagemService;

@RestController
@RequestMapping(value="/postagens")
public class PostagemResource {
	
	@Autowired
	private PostagemService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Postagem objDto) {
		
		Postagem obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Postagem objDto, @PathVariable Integer id) {
		objDto.setId(id);
		objDto = service.update(objDto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{postagemId}/", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(
			@PathVariable Integer postagemId
			) {
		service.delete(postagemId);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/findByIdUsuario/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Postagem>> find(@PathVariable Integer id) {
		List<Postagem> list = service.findByIdUsuarioSeguidos(id);
		return ResponseEntity.ok().body(list);
	}
}
