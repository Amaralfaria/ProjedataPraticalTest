package br.com.projedata.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import br.com.projedata.models.Funcionario;

public interface FuncionarioRepository {
	Funcionario save(Funcionario funcionario);
	void deleteByNome(String nome);
	List<Funcionario> findAll();
	List<Funcionario> findAllByAniversaryMonth(List<Integer> months);
	Optional<Funcionario> findOldest();
	BigDecimal getSumOfSalarios();
}
