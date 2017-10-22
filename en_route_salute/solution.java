package com.google.challenges;

public class Answer {

	public static int answer(String s) {
		int toLeft = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '<') {
				toLeft++;
			}
		}

		int result = 0;
		int consectiveToRight = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (toLeft < 1) {
				break;
			}

			if (s.charAt(i) == '<') {
				result += toLeft * consectiveToRight;
				consectiveToRight = 0;
				toLeft--;
			}
			else if (s.charAt(i) == '>') {
				consectiveToRight++;
			}
		}
		return result * 2;
	}


	public static void main(String[] args) {
		System.out.println(answer(">><><"));
	}

}
