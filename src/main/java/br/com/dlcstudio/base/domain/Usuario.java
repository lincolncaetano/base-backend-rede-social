package br.com.dlcstudio.base.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String username;
	
	@Column(unique=true)
	private String email;
	
	@JsonIgnore
	private String senha;
	
	private String nome;
	
	private String sexo;
	
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="UsuarioSeguido",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "usuarioSeguido_id")
	)
	private List<Usuario> usuarioSeguidos = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="usuarioSeguidos")
	private List<Usuario> usuarioSeguidores = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(Integer id, String nome, String email, String username, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<Usuario> getUsuarioSeguidos() {
		return usuarioSeguidos;
	}

	public void setUsuarioSeguidos(List<Usuario> usuarioSeguidos) {
		this.usuarioSeguidos = usuarioSeguidos;
	}

	public List<Usuario> getUsuarioSeguidores() {
		return usuarioSeguidores;
	}

	public void setUsuarioSeguidores(List<Usuario> usuarioSeguidores) {
		this.usuarioSeguidores = usuarioSeguidores;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
