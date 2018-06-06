package br.com.dlcstudio.base.domain;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UsuarioBloqueadoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="usuarioBloqueado_id")
	private Usuario usuarioBloqueado;
	
	public UsuarioBloqueadoPK() {
		
	}

	public UsuarioBloqueadoPK(Integer usuario, Integer usuarioBloqueado) {
		super();
		this.usuario = new Usuario(usuario);
		this.usuarioBloqueado = new Usuario(usuarioBloqueado);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioBloqueado() {
		return usuarioBloqueado;
	}

	public void setUsuarioBloqueado(Usuario usuarioBloqueado) {
		this.usuarioBloqueado = usuarioBloqueado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((usuarioBloqueado == null) ? 0 : usuarioBloqueado.hashCode());
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
		UsuarioBloqueadoPK other = (UsuarioBloqueadoPK) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (usuarioBloqueado == null) {
			if (other.usuarioBloqueado != null)
				return false;
		} else if (!usuarioBloqueado.equals(other.usuarioBloqueado))
			return false;
		return true;
	}
	
	
	
}
