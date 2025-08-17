package br.com.projedata.services;

import java.util.List;
import java.util.Map;

import br.com.projedata.models.Funcionario;

public interface FuncionarioReportService {
	void printComplete(List<Funcionario> funcionarios);
	void printByFuncao(Map<String, List<Funcionario>> map);
	void printAge(Funcionario funcionario);
	void printMinimumWages(List<Funcionario> funcionarios);
}
