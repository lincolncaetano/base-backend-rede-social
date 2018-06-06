package br.com.dlcstudio.base.dto;

import java.io.Serializable;

import br.com.dlcstudio.base.domain.UsuarioSeguido;

public class UsuarioSeguidoDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer usuarioId;
	private Integer usuarioSeguidoId;
	private String nomeUsuarioSeguido;
	private String usernameSeguido;
	
	public UsuarioSeguidoDTO(){
		
	}
	
	public UsuarioSeguidoDTO(UsuarioSeguido usuBloq){
		usuarioId = usuBloq.getId().getUsuario().getId();
		usuarioSeguidoId = usuBloq.getId().getUsuarioSeguido().getId();
		nomeUsuarioSeguido = usuBloq.getId().getUsuarioSeguido().getNome();
		usernameSeguido = usuBloq.getId().getUsuarioSeguido().getUsername();
	}
	
	public UsuarioSeguidoDTO(Integer usuarioId, Integer usuarioBloqueadoId){
		this.usuarioId = usuarioId;
		this.usuarioSeguidoId = usuarioBloqueadoId;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getUsuarioSeguidoId() {
		return usuarioSeguidoId;
	}

	public void setUsuarioSeguidoId(Integer usuarioSeguidoId) {
		this.usuarioSeguidoId = usuarioSeguidoId;
	}

	public String getNomeUsuarioSeguido() {
		return nomeUsuarioSeguido;
	}

	public void setNomeUsuarioSeguido(String nomeUsuarioSeguido) {
		this.nomeUsuarioSeguido = nomeUsuarioSeguido;
	}

	public String getUsernameSeguido() {
		return usernameSeguido;
	}

	public void setUsernameSeguido(String usernameSeguido) {
		this.usernameSeguido = usernameSeguido;
	}

}
