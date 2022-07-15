package com.patrick.chat.domain.enums;

public enum Perfil {
	
	ADMIN(0, "ROLE_ADMIN"), USUARIO(1, "ROLE_USUARIO");

	private Integer id;
	private String descricao;
	
	Perfil(int id, String descricao) {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}

	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
	}
	
	
	
}
