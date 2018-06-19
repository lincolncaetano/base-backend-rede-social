package br.com.dlcstudio.base.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dlcstudio.base.domain.Comentario;


@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
	
	
	@Transactional(readOnly=true)
	List<Comentario> findByPostagemId(Integer id);
	
}
