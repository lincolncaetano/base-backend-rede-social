package br.com.dlcstudio.base.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dlcstudio.base.domain.UsuarioBloqueado;
import br.com.dlcstudio.base.domain.UsuarioBloqueadoPK;


@Repository
public interface UsuarioBloqueadoRepository extends JpaRepository<UsuarioBloqueado, UsuarioBloqueadoPK> {
	
	
	@Transactional(readOnly=true)
	Page<UsuarioBloqueado> findByIdUsuarioId(Integer id, Pageable pageable);
	
	@Transactional(readOnly=true)
	List<UsuarioBloqueado> findByIdUsuarioId(Integer id);
	
}
