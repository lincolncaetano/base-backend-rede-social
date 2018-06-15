package br.com.dlcstudio.base.dto;

import java.io.Serializable;

public class DenunciaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idUsuario;
	private String tipoDenuncia;
	private Integer idPostagem;
	private Integer idUsuarioDenunciado;
	
	public DenunciaDTO() {
		
	}
	
	public DenunciaDTO(Integer idUsuario, String tipoDenuncia, Integer idPostagem, Integer idUsuarioDenunciado) {
		super();
		this.idUsuario = idUsuario;
		this.tipoDenuncia = tipoDenuncia;
		this.idPostagem = idPostagem;
		this.idUsuarioDenunciado = idUsuarioDenunciado;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoDenuncia() {
		return tipoDenuncia;
	}

	public void setTipoDenuncia(String tipoDenuncia) {
		this.tipoDenuncia = tipoDenuncia;
	}

	public Integer getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(Integer idPostagem) {
		this.idPostagem = idPostagem;
	}

	public Integer getIdUsuarioDenunciado() {
		return idUsuarioDenunciado;
	}

	public void setIdUsuarioDenunciado(Integer idUsuarioDenunciado) {
		this.idUsuarioDenunciado = idUsuarioDenunciado;
	}

}
