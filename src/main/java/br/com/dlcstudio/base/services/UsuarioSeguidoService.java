package br.com.dlcstudio.base.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.domain.UsuarioSeguido;
import br.com.dlcstudio.base.domain.UsuarioSeguidoPK;
import br.com.dlcstudio.base.dto.UsuarioSeguidoDTO;
import br.com.dlcstudio.base.repositories.UsuarioSeguidoRepository;
import br.com.dlcstudio.base.security.UserSS;
import br.com.dlcstudio.base.services.exceptions.AuthorizationException;
import br.com.dlcstudio.base.services.exceptions.DataIntegrityException;
import br.com.dlcstudio.base.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioSeguidoService {
	
	
	@Autowired
	private UsuarioSeguidoRepository repo;

	
public UsuarioSeguido find(UsuarioSeguidoPK id) {
		
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<UsuarioSeguido> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Usuario.class.getName());
		}
		return obj.orElse(null);
	}

public UsuarioSeguidoPK findDelete(UsuarioSeguidoPK id) {
	
	UserSS user = UserService.authenticated();
	if (user==null) {
		throw new AuthorizationException("Acesso negado");
	}
	
	Optional<UsuarioSeguido> obj = repo.findById(id);
	if(obj.isPresent()) {
		return obj.get().getId();
	}else {
		return null;
	}
	
	
}

	public UsuarioSeguido insert(UsuarioSeguido obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public UsuarioSeguido fromDTO(UsuarioSeguidoDTO objDto) {
		return new UsuarioSeguido(objDto.getUsuarioId(), objDto.getUsuarioSeguidoId());
	}

	public void delete(UsuarioSeguidoPK id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public List<UsuarioSeguido> findAll() {
		return repo.findAll();
	}
	
	public List<UsuarioSeguido> findById(Integer id) {
		return repo.findByIdUsuarioId(id);
	}
	
	public List<UsuarioSeguido> findByIdUsuarioSeguido(Integer id) {
		return repo.findByIdUsuarioSeguidoId(id);
	}

}
