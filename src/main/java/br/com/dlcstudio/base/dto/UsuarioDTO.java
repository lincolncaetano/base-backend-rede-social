package br.com.dlcstudio.base.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.dlcstudio.base.domain.Usuario;
import br.com.dlcstudio.base.domain.UsuarioSeguido;
import br.com.dlcstudio.base.services.validations.UsuarioUpdate;

@UsuarioUpdate
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	private String username;
	
	private String descricao;
	
	private String sexo;
	
	private String nascimento;
	
	private Integer qtdSeguidores;
	
	private Integer qtdSeguidos;
	
	private Integer qtdPostagem;
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		username = obj.getUsername();
		email = obj.getEmail();
		descricao = obj.getDescricao();
		qtdSeguidores = obj.getUsuarioSeguidores().size();
		qtdSeguidos = obj.getUsuarioSeguidos().size();
		qtdPostagem = obj.getListaPostagem().size();
	}
	
	public UsuarioDTO(UsuarioSeguido obj, boolean seguido) {
		if(seguido) {
			id = obj.getId().getUsuarioSeguido().getId();
			nome = obj.getId().getUsuarioSeguido().getNome();
			username = obj.getId().getUsuarioSeguido().getUsername();
		}else {
			id = obj.getId().getUsuario().getId();
			nome = obj.getId().getUsuario().getNome();
			username = obj.getId().getUsuario().getUsername();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdSeguidores() {
		return qtdSeguidores;
	}

	public void setQtdSeguidores(Integer qtdSeguidores) {
		this.qtdSeguidores = qtdSeguidores;
	}

	public Integer getQtdSeguidos() {
		return qtdSeguidos;
	}

	public void setQtdSeguidos(Integer qtdSeguidos) {
		this.qtdSeguidos = qtdSeguidos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getQtdPostagem() {
		return qtdPostagem;
	}

	public void setQtdPostagem(Integer qtdPostagem) {
		this.qtdPostagem = qtdPostagem;
	}
	
}
