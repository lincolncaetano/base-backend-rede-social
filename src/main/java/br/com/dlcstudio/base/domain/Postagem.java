package br.com.dlcstudio.base.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Postagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	private String opcao1;
	
	private String opcao2;
	
	private String pergunta;
	
	private String status;
	
	private Date dataPublicacao;

	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="postagem_id", insertable = false, updatable = false)
	@Fetch(FetchMode.SUBSELECT)
	private List<Curtida> listaCurtidas;
	
	public Postagem() {
		dataPublicacao = new Date();
	}
	
	public Postagem(Integer id) {
		this.id = id;
		dataPublicacao = new Date();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getOpcao1() {
		return opcao1;
	}

	public void setOpcao1(String opcao1) {
		this.opcao1 = opcao1;
	}

	public String getOpcao2() {
		return opcao2;
	}

	public void setOpcao2(String opcao2) {
		this.opcao2 = opcao2;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Integer> getListaCurtidas() {
		List<Integer> lista = new ArrayList<>();
		for (Curtida curtida : listaCurtidas) {
			lista.add(curtida.getId().getUsuario().getId());
		}
		return lista;
	}

	public void setListaCurtidas(List<Curtida> listaCurtidas) {
		this.listaCurtidas = listaCurtidas;
	}
	
	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
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
		Postagem other = (Postagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
