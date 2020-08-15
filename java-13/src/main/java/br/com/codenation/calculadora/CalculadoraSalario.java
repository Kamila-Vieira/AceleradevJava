package br.com.codenation.calculadora;

public class CalculadoraSalario {

	double salariomin=1039;

	public long calcularSalarioLiquido(double salarioBase) {

		double salarioliquido=0;

		if(salarioBase<=salariomin){
			salarioliquido=0.0;
		}else{
			double salarioBaseinss=salarioBase-calcularInss(salarioBase);
			salarioliquido=salarioBaseinss-calcularIrrf(salarioBaseinss);
		}

		return Math.round(salarioliquido);
	}

	private double calcularInss(double salarioBase) {

		double descontoinss;

			if(salarioBase<=1500) {
				descontoinss = 0.08 * salarioBase;
			}else if(salarioBase>4000){
					descontoinss=0.11*salarioBase;
			}else {
				descontoinss = 0.09 * salarioBase;
			}
			return descontoinss;

		}

	private double calcularIrrf(double salarioBaseinss) {

		double descontoirrf;

			if(salarioBaseinss<=3000) {
				descontoirrf = 0;
			}else if(salarioBaseinss>6000){
					descontoirrf=0.15*salarioBaseinss;
			}else{
				descontoirrf=0.075*salarioBaseinss;
		}
			return descontoirrf;
	}

}