package br.com.dlcstudio.base.resources;

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

import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.dto.UsuarioDTO;
import br.com.dlcstudio.base.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResouces {
	
	@Autowired
	private UsuarioService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<Usuario> listar() {
		
		List<Usuario> retorno = service.findAll();
		return retorno;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> find(@PathVariable Integer id) {
		Usuario obj = service.find(id);
		UsuarioDTO dto = new UsuarioDTO(obj);
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@RequestParam(value="value") String email) {
		Usuario obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/username", method=RequestMethod.GET)
	public ResponseEntity<Usuario> findByUsername(@RequestParam(value="value") String username) {
		Usuario obj = service.findByUsername(username);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/findByUsername", method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findPageUsername(
			@RequestParam(value="value") String username
		) {
		List<Usuario> list = service.findByUsernameContains(username);
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Integer id) {
		Usuario obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
