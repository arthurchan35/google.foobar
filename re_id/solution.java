package com.google.challenges;

public class Answer {

	private static int nextNo = 2;
	private static StringBuilder sb = new StringBuilder(10240);

	private static boolean isPrime() {
		for (int i = 2; i <= Math.sqrt(nextNo); ++i) {
			if (nextNo % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static void helper(int n5) {
		while (sb.length() < n5) {
			if (isPrime()) {
				sb.append(nextNo);
			}
			nextNo++;
		}
	}

	public static String answer(int n) {
		if (n + 5 <= sb.length()) {
			return sb.substring(n, n + 5);
		}
		helper(n + 5);
		return sb.substring(n, n + 5);
	}


	public static void main(String[] args) {
		System.out.println(answer(0));
		System.out.println(answer(5));
		System.out.println(answer(10));
		System.out.println(answer(15));
	}

}
