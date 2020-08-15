package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> numsfibonacci = new ArrayList<>();

		int num1 = 1, num2 = 0;

		numsfibonacci.add(num2);
		numsfibonacci.add(num1);

		while (num1 < 377) {

			num1 = num1 + num2;
			num2 = num1 - num2;

			numsfibonacci.add(num1);
		}
		return numsfibonacci;
		
	}
	public static boolean isFibonacci(Integer a) {

		return fibonacci().contains(a);
	}
	

}