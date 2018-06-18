package br.com.dlcstudio.base.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Postagem;
import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.repositories.PostagemRepository;
import br.com.dlcstudio.base.security.UserSS;
import br.com.dlcstudio.base.services.exceptions.AuthorizationException;
import br.com.dlcstudio.base.services.exceptions.DataIntegrityException;
import br.com.dlcstudio.base.services.exceptions.ObjectNotFoundException;

@Service
public class ComentarioService {
	
	@Autowired
	private PostagemRepository repo;

	public Postagem insert(Postagem obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Postagem update(Postagem obj) {
		Postagem newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Postagem newObj, Postagem obj) {
		newObj.setPergunta(obj.getPergunta());
	}
	
	public Postagem find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Postagem> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Usuario.class.getName());
		}
		return obj.orElse(null);
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível desbloquear usuário.");
		}
	}
	
	public List<Postagem> findByIdUsuario(Integer id){
		return repo.findByUsuarioId(id);
	}

}
