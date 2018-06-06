package br.com.dlcstudio.base.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dlcstudio.base.domain.UsuarioSeguido;
import br.com.dlcstudio.base.domain.UsuarioSeguidoPK;


@Repository
public interface UsuarioSeguidoRepository extends JpaRepository<UsuarioSeguido, UsuarioSeguidoPK> {

	@Transactional(readOnly=true)
	Page<UsuarioSeguido> findByIdUsuarioId(Integer id, Pageable pageable);
	
	@Transactional(readOnly=true)
	List<UsuarioSeguido> findByIdUsuarioId(Integer id);
	
	@Transactional(readOnly=true)
	Page<UsuarioSeguido> findByIdUsuarioSeguidoId(Integer id, Pageable pageable);
	
	@Transactional(readOnly=true)
	List<UsuarioSeguido> findByIdUsuarioSeguidoId(Integer id);
}
