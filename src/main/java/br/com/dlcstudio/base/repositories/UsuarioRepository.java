package br.com.dlcstudio.base.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dlcstudio.base.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
	Usuario findByEmail(String email);
	@Transactional(readOnly=true)
	List<Usuario> findByUsernameContains(String username);
	
}
