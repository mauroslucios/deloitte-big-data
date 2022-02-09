package com.big.data.desafio.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoFuncionario {
	
	ADMINISTRADOR("Administrador"),
	PADRAO("Padrao");
	TipoFuncionario(String string) {
		
	}

}
