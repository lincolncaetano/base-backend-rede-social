package br.com.dlcstudio.base.domain.enus;

public enum StatusPostagem {

	APROVADO("A", "APROVADO"),
    DELETADO("D", "DELETADO");
	
	private String codigo;
    private String tipo;
	
	private StatusPostagem(String codigo, String tipo) {
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
