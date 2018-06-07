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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.domain.UsuarioSeguido;
import br.com.dlcstudio.base.domain.UsuarioSeguidoPK;
import br.com.dlcstudio.base.dto.UsuarioDTO;
import br.com.dlcstudio.base.dto.UsuarioSeguidoDTO;
import br.com.dlcstudio.base.services.UsuarioSeguidoService;
import br.com.dlcstudio.base.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarioSeguido")
public class UsuarioSeguidoResource {
	
	@Autowired
	private UsuarioSeguidoService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/isSegue", method=RequestMethod.GET)
	public ResponseEntity<Boolean> isSegue(
			@RequestParam(value="idUsuario") Integer idUsuario, 
			@RequestParam(value="idUsuarioLogado") Integer idUsuarioLogado
	) {
		boolean retorno = false;
		Usuario obj = usuarioService.find(idUsuarioLogado);
		for (int i = 0; i < obj.getUsuarioSeguidos().size(); i++) {
			if(idUsuario.equals(obj.getUsuarioSeguidos().get(i).getId())) {
				retorno = true;
			}
		}
		
		return ResponseEntity.ok().body(retorno);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioSeguidoDTO objDto) {
		UsuarioSeguido obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{usuarioId}/{usuarioSeguidoId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(
			@PathVariable Integer usuarioId, 
			@PathVariable Integer usuarioSeguidoId
			) {
		
		UsuarioSeguidoPK id = new UsuarioSeguidoPK(new Usuario(usuarioId), new Usuario(usuarioSeguidoId));
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="listaSeguindo/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findById(@PathVariable Integer id) {
		List<UsuarioSeguido> list = service.findById(id);
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj, true)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="listaSeguidores/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findByIdUsuarioSeguido(@PathVariable Integer id) {
		List<UsuarioSeguido> list = service.findByIdUsuarioSeguido(id);
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj, false)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}

}
