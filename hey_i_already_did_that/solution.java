package com.google.challenges;

import java.util.Arrays;
import java.util.HashMap;

public class Answer {

	private static String getNextID(char[] asc, int b) {
		char[] result = new char[asc.length];

		boolean carry = false;
		for (int i = 0; i < asc.length; ++i) {
			int diff = asc[i] - asc[asc.length - 1 - i];

			if (carry) {
				diff -= 1;
				if (diff < 0) {
					result[asc.length - 1 - i] = (char) ('0' + (diff + b));
				}
				else {
					result[asc.length - 1 - i] = (char) ('0' + diff);
					carry = false;
				}
			}
			else {
				if (diff < 0) {
					result[asc.length - 1 - i] = (char) ('0' + (diff + b));
					carry = true;
				}
				else {
					result[asc.length - 1 - i] = (char) ('0' + diff);
				}
			}
		}

		return new String(result);
	}

	public static int answer(String n, int b) {

		HashMap<String, Integer> nmap = new HashMap<String, Integer>();

		String curr = n;
		int index = 0;
		while (!nmap.containsKey(curr)) {
			nmap.put(curr, index);
			char[] asc = curr.toCharArray();
			Arrays.sort(asc);
			curr = getNextID(asc, b);
			index += 1;
		}

		return index - nmap.get(curr);
	}

	public static void main(String[] args) {
		System.out.println(answer("210022", 3));
	}

}
