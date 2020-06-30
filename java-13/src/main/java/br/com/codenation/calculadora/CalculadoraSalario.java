package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		if (salarioBase < 1039) {
			return 0;
		}

		double salarioINSS = calcularInss(salarioBase);
		double novoSalario, salarioLiquido;

		novoSalario = salarioBase - salarioINSS;

		if (novoSalario <= 3000.00) {
			salarioLiquido = novoSalario;
		}
		else if (novoSalario <= 6000.00) {
			salarioLiquido = novoSalario - (novoSalario * 0.075);
		}
		else {
			salarioLiquido = novoSalario - (novoSalario * 0.15);
		}

		return (int) Math.round(salarioLiquido);
	}


	private double calcularInss(double salarioBase) {

		double salarioINSS;

		if (salarioBase <= 1500.00) {
			salarioINSS = salarioBase * 0.08;
		}
		else if (salarioBase <= 4000.00) {
			salarioINSS = salarioBase * 0.09;
		}
		else {
			salarioINSS = salarioBase * 0.11;
		}

		return salarioINSS;
	}
}