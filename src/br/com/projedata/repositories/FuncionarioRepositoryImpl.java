package br.com.projedata.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import br.com.projedata.models.Funcionario;

public class FuncionarioRepositoryImpl implements FuncionarioRepository{
	private final List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	@Override
	public Funcionario save(Funcionario funcionario) {
		funcionarios.add(funcionario);
		
		return funcionario;
	}

	@Override
	public void deleteByNome(String nome) {
		funcionarios.removeIf(f -> f.getNome().equals(nome));
	}

	@Override
	public List<Funcionario> findAll() {
		return funcionarios.stream().toList();
	}

	@Override
	public List<Funcionario> findAllByAniversaryMonth(List<Integer> months) {
		return funcionarios.stream()
							.filter(f -> months.contains(f.getDataNascimento().getMonthValue()))
							.toList();
	}

	@Override
	public Optional<Funcionario> findOldest() {
		return funcionarios.stream()
							.max(Comparator.comparing(Funcionario::getAge));
	}

	@Override
	public BigDecimal getSumOfSalarios() {
		return funcionarios.stream()
							.map(f -> f.getSalario())
							.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
