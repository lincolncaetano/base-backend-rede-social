package br.com.dlcstudio.base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Curtida;
import br.com.dlcstudio.base.domain.CurtidaPK;
import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.repositories.CurtidaRepository;
import br.com.dlcstudio.base.security.UserSS;
import br.com.dlcstudio.base.services.exceptions.AuthorizationException;
import br.com.dlcstudio.base.services.exceptions.DataIntegrityException;
import br.com.dlcstudio.base.services.exceptions.ObjectNotFoundException;

@Service
public class CurtidaService {
	
	@Autowired
	private CurtidaRepository repo;

	public Curtida insert(Curtida obj) {
		obj = repo.save(obj);
		return obj;
	}
	
	public List<Curtida> findByIdPostagemId(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		List<Curtida> obj = repo.findByIdPostagemId(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}
	
	public void delete(CurtidaPK id) {
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível desbloquear usuário.");
		}
	}

}
