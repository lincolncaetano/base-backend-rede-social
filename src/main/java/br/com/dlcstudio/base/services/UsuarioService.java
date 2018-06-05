package br.com.dlcstudio.base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioRepository repo;
	

	
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
}
