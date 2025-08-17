package br.com.projedata.formatters;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

import br.com.projedata.models.Funcionario;

public class FuncionarioFormatter {
	private DateTimeFormatter dateFormat;
    private NumberFormat numberFormat;
    
    public FuncionarioFormatter(DateTimeFormatter dateFormat, NumberFormat numberFormat) {
		super();
		this.dateFormat = dateFormat;
		this.numberFormat = numberFormat;
	}
	
	public String formatAge(Funcionario funcionario) {
		return String.format("Nome: %s\nIdade: %d\n", funcionario.getNome(), funcionario.getAge());
	}
	
	public String formatMinimumWage(Funcionario funcionario) {
		return String.format("Nome: %s\nSalários mínimos: %s\n", funcionario.getNome(), numberFormat.format(funcionario.getNumberOfMinimumWages()));
	}
	
	public String formatComplete(Funcionario funcionario) {
		return String.format("Nome: %s\nData de nascimento: %s\nFunção: %s\nSalário: %s\n", 
				funcionario.getNome(), 
				funcionario.getDataNascimento().format(dateFormat), 
				funcionario.getFuncao(),
				numberFormat.format(funcionario.getSalario()));
	}
	
	
}
