package br.com.projedata;

import java.math.BigDecimal;
import java.text.NumberFormat;

import br.com.projedata.config.AppContext;
import br.com.projedata.services.FuncionarioReportService;
import br.com.projedata.services.FuncionarioService;
import br.com.projedata.utils.Constants;

public class Main {

	public static void main(String[] args) {
		AppContext appContext = new AppContext();
		appContext.init();
		FuncionarioService funcionarioService = appContext.getService(FuncionarioService.class);
		FuncionarioReportService funcionarioReportService = appContext.getService(FuncionarioReportService.class);
		NumberFormat numberFormat = appContext.getService(NumberFormat.class);
		
		funcionarioService.deleteByNome(Constants.FUNCIONARIO_NOME_TO_BE_REMOVED);
		funcionarioReportService.printComplete(funcionarioService.findAll());
		funcionarioService.applySalarioRaiseToAll(new BigDecimal(Constants.FUNCIONARIOS_PERCENTAGE_RAISE));
		
		funcionarioReportService.printByFuncao(funcionarioService.groupByFuncao());
		funcionarioReportService.printComplete(funcionarioService.findAllByAniversaryMonth(Constants.FUNCIONARIOS_DESIRED_MONTHS));
		
		var oldestEmployee = funcionarioService.findOldest();
		if(oldestEmployee.isPresent()) {
			funcionarioReportService.printAge(oldestEmployee.get());
		}
		
		funcionarioReportService.printComplete(funcionarioService.findAllSortedByNome());
		
		System.out.println(numberFormat.format(funcionarioService.getSumOfSalarios()) + "\n");
		
		funcionarioReportService.printMinimumWages(funcionarioService.findAll());
	}

}
