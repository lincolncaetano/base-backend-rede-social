package br.com.dlcstudio.base.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dlcstudio.base.domain.Usuario;
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
}
