package com.big.data.desafio.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.big.data.desafio.enums.TipoServico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb-servico")
@AllArgsConstructor
@Getter
@Setter
public class Serviço {

	private Long id;
	private TipoServico tipo;
	private String descricao;
}
