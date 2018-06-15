package br.com.dlcstudio.base.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dlcstudio.base.domain.Denuncia;
import br.com.dlcstudio.base.dto.DenunciaDTO;
import br.com.dlcstudio.base.services.DenunciaService;

@RestController
@RequestMapping(value="/denuncia")
public class DenunciaResource {
	
	@Autowired
	private DenunciaService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody DenunciaDTO objDto) {
		
		Denuncia denuncia = service.fronDTO(objDto);
		Denuncia obj = service.insert(denuncia);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
