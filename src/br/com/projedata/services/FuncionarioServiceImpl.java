package br.com.projedata.services;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.projedata.models.Funcionario;
import br.com.projedata.repositories.FuncionarioRepository;

public class FuncionarioServiceImpl implements FuncionarioService{
	private final FuncionarioRepository funcionarioRepository;

	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
		super();
		this.funcionarioRepository = funcionarioRepository;
	}

	@Override
	public void applySalarioRaiseToAll(BigDecimal percentage) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		
		for(Funcionario f : funcionarios){
			f.applySalarioRaise(percentage);
		}
	}

	@Override
	public Map<String, List<Funcionario>> groupByFuncao() {
		return funcionarioRepository.findAll().stream()
					.collect(Collectors.groupingBy(f -> f.getFuncao()));
	}

	@Override
	public List<Funcionario> findAllByAniversaryMonth(List<Integer> months) {
		return funcionarioRepository.findAllByAniversaryMonth(months);
	}

	@Override
	public Optional<Funcionario> findOldest() {
		return funcionarioRepository.findOldest();
	}

	@Override
	public BigDecimal getSumOfSalarios() {
		return funcionarioRepository.getSumOfSalarios();
	}

	@Override
	public List<Funcionario> findAllSortedByNome() {
		return funcionarioRepository.findAll() 
									.stream()
									.sorted(Comparator.comparing(Funcionario::getNome))
									.toList();
	}

	@Override
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

	@Override
	public void deleteByNome(String nome) {
		funcionarioRepository.deleteByNome(nome);
	}

}
