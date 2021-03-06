package com.big.data.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.big.data.desafio.enums.TipoFuncionario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_funcionario")
public class Funcionario  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="departamento_id")
	private Departamento departamento;
	
	@NotBlank
	@Size(min = 3, message = "Nome deve conter no mínimo 3 caracteres")
	@Size(max = 30, message = "Nome deve conter no máximo 30 caracteres")
	private String nome;
	
	@NotBlank
	@Size(max = 11, message = "Cpf deve conter no mínimo 11 caracteres")
	@Size(min = 11, message = "Cpf deve conter no máximo 11 caracteres")
	@Column(unique=true)
	private String cpf;
	
	@NotBlank
	@Email
	@Column(unique=true)
	private String email;
	
	@NotBlank
	@Column(unique=true)
	private String senha;
	
	@Column(nullable = false) 
	@Enumerated(EnumType.STRING) 
	TipoFuncionario tipo;
}
