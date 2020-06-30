package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {

		int i, soma = 0;
		int tamanho = elements.length;

		for (i = 0; i < tamanho; i++) {
			soma += elements[i];

		}
		return soma / tamanho;
	}

	public static int mode(int[] elements) {

		int i, j, repeticao, moda = 0, contador = 0;
		int tamanho = elements.length;

		Arrays.sort(elements);

		for (i = 0; i < tamanho; i++) {
			repeticao = 0;
			for (j = 1; j < tamanho; j++)
				if (elements[i] == elements[j]) {
					repeticao++;
				}

			if (repeticao > contador) {
				moda = elements[i];
				contador = repeticao;
			}
		}
		return moda;
	}

	public static int median(int[] elements) {

		int tamanho = elements.length;
		int imparOuPar = tamanho % 2;
		int metade = tamanho / 2;
		int mediana;

		Arrays.sort(elements);

		if (imparOuPar == 1) {
			return elements[metade];
		} else {
			mediana = (elements[metade] + elements[metade-1]) / 2;
			return mediana;
		}
	}
}