package br.com.dlcstudio.base.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dlcstudio.base.domain.UsuarioBloqueado;
import br.com.dlcstudio.base.domain.UsuarioBloqueadoPK;
import br.com.dlcstudio.base.dto.UsuarioBloqueadoDTO;
import br.com.dlcstudio.base.dto.UsuarioDTO;
import br.com.dlcstudio.base.services.UsuarioBloqueadoService;

@RestController
@RequestMapping(value="/usuarioBloqueado")
public class UsuarioBloqueadoResource {
	
	@Autowired
	private UsuarioBloqueadoService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioBloqueadoDTO objDto) {
		UsuarioBloqueado obj = service.insert(new UsuarioBloqueado(objDto.getUsuarioId(), objDto.getUsuarioBloqueadoId()));
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{usuarioId}/{usuarioBloqueadoId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(
			@PathVariable Integer usuarioId, 
			@PathVariable Integer usuarioBloqueadoId
			) {
		
		UsuarioBloqueadoPK id = new UsuarioBloqueadoPK(usuarioId, usuarioBloqueadoId);
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="listaPorUsuario/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findUsuarioBloqueadoId(@PathVariable Integer id) {
		List<UsuarioBloqueado> list = service.findById(id);
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj.getId().getUsuarioBloqueado())).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}

}
