package br.com.dlcstudio.base.dto;

import java.io.Serializable;

import br.com.dlcstudio.base.domain.UsuarioBloqueado;

public class UsuarioBloqueadoDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer usuarioId;
	private Integer usuarioBloqueadoId;
	private String nomeUsuarioBloq;
	private String usernameBloq;
	
	public UsuarioBloqueadoDTO(){
		
	}
	
	public UsuarioBloqueadoDTO(UsuarioBloqueado usuBloq){
		usuarioId = usuBloq.getId().getUsuario().getId();
		usuarioBloqueadoId = usuBloq.getId().getUsuarioBloqueado().getId();
		nomeUsuarioBloq = usuBloq.getId().getUsuarioBloqueado().getNome();
		usernameBloq = usuBloq.getId().getUsuarioBloqueado().getUsername();
	}
	
	public UsuarioBloqueadoDTO(Integer usuarioId, Integer usuarioBloqueadoId){
		this.usuarioId = usuarioId;
		this.usuarioBloqueadoId = usuarioBloqueadoId;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


	public Integer getUsuarioBloqueadoId() {
		return usuarioBloqueadoId;
	}


	public void setUsuarioBloqueadoId(Integer usuarioBloqueadoId) {
		this.usuarioBloqueadoId = usuarioBloqueadoId;
	}

	public String getNomeUsuarioBloq() {
		return nomeUsuarioBloq;
	}

	public void setNomeUsuarioBloq(String nomeUsuarioBloq) {
		this.nomeUsuarioBloq = nomeUsuarioBloq;
	}

	public String getUsernameBloq() {
		return usernameBloq;
	}

	public void setUsernameBloq(String usernameBloq) {
		this.usernameBloq = usernameBloq;
	}
	
	
	
	
}
