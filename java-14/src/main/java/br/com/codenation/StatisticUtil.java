package br.com.codenation;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StatisticUtil {

	int[] elements;

	public static int average(int[] elements) {

		List<Integer> Average = new ArrayList<Integer>();

		for(int x : elements) {
			Average.add(x);
		}
		double media = Average.stream()
				.mapToInt(Media -> Media)
				.average()
				.getAsDouble();

		return (int) media;
}

	public static int mode(int[] elements) {

		int mode = elements[0];
		int maxCount = 0;
		for (int i = 0; i < elements.length; i++) {
			int value = elements[i];
			int count = 1;
			for (int j = 0; j < elements.length; j++) {
				if (elements[j] == value) count++;
				if (count > maxCount) {
					mode = value;
					maxCount = count;
				}
			}
		}
		return mode;
	}

	public static int median(int[] elements) {

		Arrays.sort(elements);
		if(elements.length % 2 != 0){
		return elements[(int)Math.floor(elements.length/2)];
		}else{
		return Math.round((elements[(elements.length / 2) - 1] + elements[elements.length / 2]) / 2);
		}
	}
}