package br.com.dlcstudio.base.domain;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CurtidaPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="postagem_id")
	private Postagem postagem;
	
	public CurtidaPK() {
		
	}

	public CurtidaPK(Integer idUsuario, Integer idPostagem) {
		super();
		this.usuario = new Usuario(idUsuario);
		this.postagem = new Postagem(idPostagem);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((postagem == null) ? 0 : postagem.hashCode());
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
		CurtidaPK other = (CurtidaPK) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (postagem == null) {
			if (other.postagem != null)
				return false;
		} else if (!postagem.equals(other.postagem))
			return false;
		return true;
	}
	
	
	
}
