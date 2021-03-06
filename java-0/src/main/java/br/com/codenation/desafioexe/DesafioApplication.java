package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> Lista = new ArrayList<Integer>(Arrays.asList());
		int n = 0;
		int i;
		int cont = 1;
		int n_anterior = 1;
		int n_anterior2 = 0;

		for (i = 0; cont < 350; i++) {
			if(i <= 1){
				Lista.add(i);
			} else{
				n = n_anterior + n_anterior2;
				Lista.add(n);
				n_anterior2 = n_anterior;
				n_anterior = n;
			}
			cont = n;
		}
		return Lista;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}
}