package br.com.dlcstudio.base.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.domain.UsuarioBloqueado;
import br.com.dlcstudio.base.domain.UsuarioBloqueadoPK;
import br.com.dlcstudio.base.domain.UsuarioSeguidoPK;
import br.com.dlcstudio.base.repositories.UsuarioBloqueadoRepository;
import br.com.dlcstudio.base.security.UserSS;
import br.com.dlcstudio.base.services.exceptions.AuthorizationException;
import br.com.dlcstudio.base.services.exceptions.DataIntegrityException;
import br.com.dlcstudio.base.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioBloqueadoService {
	
	
	@Autowired
	private UsuarioBloqueadoRepository repo;
	
	@Autowired
	private UsuarioSeguidoService repoSeguido;

	
	public UsuarioBloqueado find(UsuarioBloqueadoPK id) {
		
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<UsuarioBloqueado> obj = repo.findById(id);
		if (!obj.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Usuario.class.getName());
		}
		return obj.orElse(null);
	}

	public UsuarioBloqueado insert(UsuarioBloqueado obj) {
		
		UsuarioSeguidoPK seguido = repoSeguido.findDelete(new UsuarioSeguidoPK(obj.getId().getUsuario(), obj.getId().getUsuarioBloqueado()));
		if(seguido != null) {
			repoSeguido.delete(seguido);
		}
		UsuarioSeguidoPK seguidoAux = repoSeguido.findDelete(new UsuarioSeguidoPK(obj.getId().getUsuarioBloqueado(), obj.getId().getUsuario()));
		if(seguidoAux != null) {
			repoSeguido.delete(seguidoAux);
		}
		
		obj = repo.save(obj);
		return obj;
	}
	

	public void delete(UsuarioBloqueadoPK id) {
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível desbloquear usuário.");
		}
	}
	
	public List<UsuarioBloqueado> findAll() {
		return repo.findAll();
	}
	
	public List<UsuarioBloqueado> findById(Integer id) {
		return repo.findByIdUsuarioId(id);
	}

}
