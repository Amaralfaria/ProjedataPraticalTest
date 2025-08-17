package br.com.projedata.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
	private BigDecimal salario;
	private String funcao;
	
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public BigDecimal getNumberOfMinimumWages() {
		return salario.divide(new BigDecimal("1212.00"), 2, RoundingMode.HALF_UP);
	}
	
	public void applySalarioRaise(BigDecimal percentual) {
        this.salario = this.salario.multiply(BigDecimal.ONE.add(percentual.divide(BigDecimal.valueOf(100))));
    }
}
