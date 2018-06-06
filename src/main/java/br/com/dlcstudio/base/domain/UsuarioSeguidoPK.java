package br.com.dlcstudio.base.domain;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UsuarioSeguidoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="usuarioSeguido_id")
	private Usuario usuarioSeguido;
	
	public UsuarioSeguidoPK() {
		
	}
	
	public UsuarioSeguidoPK(Usuario usuario, Usuario usuarioSeguido) {
		super();
		this.usuario = usuario;
		this.usuarioSeguido = usuarioSeguido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSeguido() {
		return usuarioSeguido;
	}

	public void setUsuarioSeguido(Usuario usuarioSeguido) {
		this.usuarioSeguido = usuarioSeguido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((usuarioSeguido == null) ? 0 : usuarioSeguido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioSeguidoPK other = (UsuarioSeguidoPK) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (usuarioSeguido == null) {
			if (other.usuarioSeguido != null)
				return false;
		} else if (!usuarioSeguido.equals(other.usuarioSeguido))
			return false;
		return true;
	}
	
	
}
