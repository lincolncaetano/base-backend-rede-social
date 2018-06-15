package br.com.dlcstudio.base.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.dlcstudio.base.domain.enus.TipoDenuncia;

@Entity
public class Denuncia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")  
	private Usuario usuario;
	
	private Integer tipoDenuncia;
	
	@ManyToOne
    @JoinColumn(name = "postagem_id")  
	private Postagem postagem;
	
	@ManyToOne
    @JoinColumn(name = "usuarioDenunciado_id")  
	private Usuario usuarioDenunciado;
	
	public Denuncia(Long id, Usuario usuario, TipoDenuncia tipoDenuncia, Postagem postagem, Usuario usuarioDenunciado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.tipoDenuncia = (tipoDenuncia==null) ? null : tipoDenuncia.getCodigo();
		this.postagem = postagem;
		this.usuarioDenunciado = usuarioDenunciado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getTipoDenuncia() {
		return tipoDenuncia;
	}

	public void setTipoDenuncia(Integer tipoDenuncia) {
		this.tipoDenuncia = tipoDenuncia;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public Usuario getUsuarioDenunciado() {
		return usuarioDenunciado;
	}

	public void setUsuarioDenunciado(Usuario usuarioDenunciado) {
		this.usuarioDenunciado = usuarioDenunciado;
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
		Denuncia other = (Denuncia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
