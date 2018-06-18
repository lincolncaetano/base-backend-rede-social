package br.com.dlcstudio.base.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dlcstudio.base.domain.Curtida;
import br.com.dlcstudio.base.domain.CurtidaPK;


@Repository
public interface CurtidaRepository extends JpaRepository<Curtida, CurtidaPK> {
	
	
	@Transactional(readOnly=true)
	List<Curtida> findByIdPostagemId(Integer id);
	
}
