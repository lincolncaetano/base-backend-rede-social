package br.com.dlcstudio.base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Comentario;
import br.com.dlcstudio.base.repositories.ComentarioRepository;
import br.com.dlcstudio.base.services.exceptions.DataIntegrityException;

@Service
public class ComentarioService {
	
	@Autowired
	private ComentarioRepository repo;

	public Comentario insert(Comentario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível desbloquear usuário.");
		}
	}
	
	public List<Comentario> findByPostagemId(Integer id){
		return repo.findByPostagemId(id);
	}

}
