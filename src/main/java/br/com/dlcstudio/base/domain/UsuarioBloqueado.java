package br.com.dlcstudio.base.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UsuarioBloqueado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UsuarioBloqueadoPK id = new UsuarioBloqueadoPK();
	
	public UsuarioBloqueado() {
	}

	public UsuarioBloqueado(Integer usuarioLog, Integer usuarioBloqueado) {
		super();
		id.setUsuario(new Usuario(usuarioLog));
		id.setUsuarioBloqueado(new Usuario(usuarioBloqueado));
	}
	
	public UsuarioBloqueadoPK getId() {
		return id;
	}

	public void setId(UsuarioBloqueadoPK id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UsuarioBloqueado other = (UsuarioBloqueado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
