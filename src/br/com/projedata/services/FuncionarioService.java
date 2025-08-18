package br.com.projedata.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.projedata.models.Funcionario;

public interface FuncionarioService {
	void applySalarioRaiseToAll(BigDecimal percentage);
	Map<String, List<Funcionario>> groupByFuncao();
	List<Funcionario> findAllByAniversaryMonth(List<Integer> months);
	Optional<Funcionario> findOldest();
	BigDecimal getSumOfSalarios();
	List<Funcionario> findAllSortedByNome();
	List<Funcionario> findAll();
	void deleteByNome(String nome);
}
