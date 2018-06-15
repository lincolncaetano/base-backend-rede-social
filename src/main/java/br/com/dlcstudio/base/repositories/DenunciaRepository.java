package br.com.dlcstudio.base.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dlcstudio.base.domain.Denuncia;


@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
	
	
}
