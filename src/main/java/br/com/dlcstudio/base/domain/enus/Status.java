package br.com.dlcstudio.base.domain.enus;

public enum Status {

	PENDENTE("P", "PENDENTE"),
	APROVADO("A", "APROVADO");
	
	private String codigo;
    private String tipo;
	
	private Status(String codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public String getTipo() {
		return tipo;
	}

}
