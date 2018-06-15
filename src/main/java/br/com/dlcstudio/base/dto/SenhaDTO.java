package br.com.dlcstudio.base.dto;

import java.io.Serializable;

public class SenhaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String senhaAntiga;
	private String senha;
	
	public SenhaDTO() {
		
	}

	public String getSenhaAntiga() {
		return senhaAntiga;
	}

	public void setSenhaAntiga(String senhaAntiga) {
		this.senhaAntiga = senhaAntiga;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
