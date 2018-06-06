package br.com.dlcstudio.base.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import br.com.dlcstudio.base.domain.enus.Status;

@Entity
public class UsuarioSeguido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UsuarioSeguidoPK id = new UsuarioSeguidoPK();
	
	private String status;
		
	public UsuarioSeguido() {
	}

	public UsuarioSeguido(Usuario usuarioLog, Usuario usuarioSeguido) {
		super();
		id.setUsuario(usuarioLog);
		id.setUsuarioSeguido(usuarioSeguido);
		setStatus(Status.PENDENTE.getCodigo());
	}
	
	public UsuarioSeguido(Integer idUsuario, Integer idUsuarioSeguido) {
		super();
		id.setUsuario(new Usuario(idUsuario));
		id.setUsuarioSeguido(new Usuario(idUsuarioSeguido));
		setStatus(Status.PENDENTE.getCodigo());
	}
	
	public UsuarioSeguidoPK getId() {
		return id;
	}

	public void setId(UsuarioSeguidoPK id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		UsuarioSeguido other = (UsuarioSeguido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
