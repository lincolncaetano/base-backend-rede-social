package br.com.dlcstudio.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dlcstudio.base.domain.Denuncia;
import br.com.dlcstudio.base.domain.Postagem;
import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.domain.enus.TipoDenuncia;
import br.com.dlcstudio.base.dto.DenunciaDTO;
import br.com.dlcstudio.base.repositories.DenunciaRepository;

@Service
public class DenunciaService {
	
	@Autowired
	private DenunciaRepository repo;

	public Denuncia insert(Denuncia obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Denuncia fronDTO(DenunciaDTO dto) {
		
		Usuario usuario = new Usuario(dto.getIdUsuario());
		Usuario usuarioDenunciado = null;
		if(dto.getIdUsuarioDenunciado() != null) {
			usuarioDenunciado = new Usuario(dto.getIdUsuarioDenunciado());
		}
		Postagem postagem = null;
		if(dto.getIdPostagem() != null) {
			postagem = new Postagem();
			postagem.setId(dto.getIdPostagem());
		}
		
		Denuncia denuncia = new Denuncia(null, usuario, TipoDenuncia.toEnum(dto.getIdUsuarioDenunciado()),postagem, usuarioDenunciado);
		
		return denuncia;
	}
}
