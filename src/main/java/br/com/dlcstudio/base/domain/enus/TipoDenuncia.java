package br.com.dlcstudio.base.domain.enus;

public enum TipoDenuncia {
	
	AUTOMUTILACAO(1, "AUTOMUTILACAO"),
	DROGAS(2, "DROGAS"),
	ASSEDIO(3, "ASSEDIO"),
	ARMA(4, "ARMA"),
	NUDEZ(5, "NUDEZ"),
	ODIO(6, "ODIO"),
	PROPRIEDADE(7, "PROPRIEDADE");
	
	private int codigo;
    private String tipo;
	
	private TipoDenuncia(int codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getTipo() {
		return tipo;
	}
	
	public static TipoDenuncia toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoDenuncia x : TipoDenuncia.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
