package com.ashdom.interview;

public class PasswordChecker {

	public int strongPasswordChecker(String password) {
		int minSteps = 0;
		boolean digitPresent = false;
		boolean uppercasePresent = false;
		boolean lowercasePresent = false;
		char prev = 0;
		int repeatCount = 0;
		int countOfRepeats = 0;
		for (int i = 0; i < password.length(); i++) {
			if (!digitPresent && Character.isDigit(password.charAt(i))) {
				digitPresent = true;
			}
			if (!uppercasePresent && Character.isUpperCase(password.charAt(i))) {
				uppercasePresent = true;
			}
			if (!lowercasePresent && Character.isLowerCase(password.charAt(i))) {
				lowercasePresent = true;
			}
			if (prev != 0) {
				if (prev == password.charAt(i)) {
					repeatCount++;
					if (repeatCount == 2) {
						countOfRepeats++;
						repeatCount = 0;
						prev = 0;
						continue;
					}
				} else {
					repeatCount = 0;
				}
			}
			prev = password.charAt(i);
		}
		if (!digitPresent)
			minSteps++;
		if (!uppercasePresent)
			minSteps++;
		if (!lowercasePresent)
			minSteps++;
		minSteps = Math.max(minSteps, countOfRepeats);
		if (password.length() < 6) {
			int diff = 6 - password.length();
			minSteps = Math.max(minSteps, diff);
		}
		if (password.length() > 20) {
			int diff = password.length() - 20;
			minSteps = minSteps + diff;
		}
		return minSteps;
	}
}
