package com.big.data.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.big.data.desafio.dto.FuncionarioDTO;
import com.big.data.desafio.model.Funcionario;
import com.big.data.desafio.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {
	
	private FuncionarioRepository funcionarioRepository;

	public List<FuncionarioDTO> findAll() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return FuncionarioDTO.converter(funcionarios);
	}

	public Funcionario listarFuncionariosPorId(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.orElse(null);
		
	}

	public Funcionario insertFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public void deleteProduto(Long id) {
		funcionarioRepository.deleteById(id);
	}

	public Funcionario alterarFuncionario(Long id, Funcionario funcionario) {
		Funcionario detalhesFuncionario = listarFuncionariosPorId(id);
		detalhesFuncionario.setNome(funcionario.getNome());
		detalhesFuncionario.setCpf(funcionario.getCpf());
		detalhesFuncionario.setEmail(funcionario.getEmail());
		detalhesFuncionario.setSenha(funcionario.getSenha());
		detalhesFuncionario.setDepartamento(funcionario.getDepartamento());
		detalhesFuncionario.setTipo(funcionario.getTipo());
		return funcionarioRepository.save(detalhesFuncionario);
	}

	

//	public Funcionario updateFuncionario(Funcionario funcionario,Long id) {
//		
//		Funcionario updatedFuncionario = new Funcionario();
//		Optional<Funcionario> saveFuncionario = funcionarioRepository.findById(id);
//		Funcionario updateFuncionario = saveFuncionario.get();
//		
//		updatedFuncionario = funcionarioRepository.save(updateFuncionario);
//		return updateFuncionario;
//	}
//
	
//	public Funcionario findById(@RequestBody Funcionario newfuncionario,@PathVariable Long id) {
//		return funcionarioRepository.findById(id)
//				.map(func-> {
//					func.setNome(newfuncionario.getNome());
//					func.setCpf(newfuncionario.getCpf());
//					func.setEmail(newfuncionario.getEmail());
//					func.setDepartamento(newfuncionario.getDepartamento());
//					func.setTipo(newfuncionario.getTipo());
//					func.setSenha(newfuncionario.getSenha());
//					return funcionarioRepository.save(newfuncionario);
//				}).orElseGet(()->{
//					newfuncionario.setId(id);
//					return funcionarioRepository.save(newfuncionario);
//				});
//	}
//
//	public Funcionario findById(Long id, Funcionario funcionarioDetalhes) {
//		return funcionarioRepository.findById(id)
//				.map(func-> {
//					func.setNome(funcionarioDetalhes.getNome());
//					func.setCpf(funcionarioDetalhes.getCpf());
//					func.setEmail(funcionarioDetalhes.getEmail());
//					func.setDepartamento(funcionarioDetalhes.getDepartamento());
//					func.setTipo(funcionarioDetalhes.getTipo());
//					func.setSenha(funcionarioDetalhes.getSenha());
//					return funcionarioRepository.save(funcionarioDetalhes);
//				}).orElseGet(()->{
//					funcionarioDetalhes.setId(id);
//					return funcionarioRepository.save(funcionarioDetalhes);
//				});
//	}

		
	
}
