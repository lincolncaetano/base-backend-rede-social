package br.com.dlcstudio.base.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.dto.UsuarioDTO;
import br.com.dlcstudio.base.repositories.UsuarioRepository;
import br.com.dlcstudio.base.security.UserSS;
import br.com.dlcstudio.base.services.exceptions.AuthorizationException;
import br.com.dlcstudio.base.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		Usuario usuario = new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail(),objDto.getUsername(), null);
		usuario.setSexo(objDto.getSexo());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			usuario.setNascimento(sdf.parse(objDto.getNascimento()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Usuario findByEmail(String email) {
		
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Usuario> obj = repo.findById(user.getId());
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + user.getId()
					+ ", Tipo: " + Usuario.class.getName());
		}
		return obj.orElse(null);
	}
	
	public Usuario findByUsername(String username) {
		
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Usuario> obj = repo.findById(user.getId());
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + user.getId()
					+ ", Tipo: " + Usuario.class.getName());
		}
		return obj.orElse(null);
	}
	
	public Usuario find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Usuario> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Usuario.class.getName());
		}
		return obj.orElse(null);
	}
	
	public List<Usuario> findByUsernameContains(String username) {
		return repo.findByUsernameContains(username);
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setSexo(obj.getSexo());
		newObj.setNascimento(obj.getNascimento());
	}
}
