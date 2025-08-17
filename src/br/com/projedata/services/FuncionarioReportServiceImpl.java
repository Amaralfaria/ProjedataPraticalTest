package br.com.projedata.services;

import java.util.List;
import java.util.Map;

import br.com.projedata.formatters.FuncionarioFormatter;
import br.com.projedata.models.Funcionario;

public class FuncionarioReportServiceImpl implements FuncionarioReportService{
	private final FuncionarioFormatter funcionarioFormatter;

	public FuncionarioReportServiceImpl(FuncionarioFormatter funcionarioFormatter) {
		super();
		this.funcionarioFormatter = funcionarioFormatter;
	}

	@Override
	public void printComplete(List<Funcionario> funcionarios) {
		funcionarios.forEach(f -> System.out.println(funcionarioFormatter.formatComplete(f)));
	}

	@Override
	public void printByFuncao(Map<String, List<Funcionario>> map) {
		map.forEach((funcao, funcionarios) -> {
			System.out.println(funcao);
			this.printComplete(funcionarios);
		});
	}

	@Override
	public void printAge(Funcionario funcionario) {
		System.out.println(funcionarioFormatter.formatAge(funcionario));
	}

	@Override
	public void printMinimumWages(List<Funcionario> funcionarios) {
		funcionarios.forEach(f -> System.out.println(funcionarioFormatter.formatMinimumWage(f)));
	}
}
