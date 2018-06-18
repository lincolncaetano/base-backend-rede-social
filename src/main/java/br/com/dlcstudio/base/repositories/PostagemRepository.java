package br.com.dlcstudio.base.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dlcstudio.base.domain.Postagem;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
	
	
	@Transactional(readOnly=true)
	List<Postagem> findByUsuarioId(Integer id);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Postagem obj WHERE obj.usuario.id in (select " + 
			"usuarioseg.id.usuarioSeguido.id " + 
			"from "+ 
			"UsuarioSeguido usuarioseg " + 
			"where "+ 
			"usuarioseg.id.usuario.id= :id ) OR obj.usuario.id = :id "+
			"ORDER BY obj.id DESC")
	List<Postagem> findPostagemBySeguidos(@Param("id")Integer id);
	
}
