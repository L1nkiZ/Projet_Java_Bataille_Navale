package fr.iut.cpoa.tools;

public class Utils {

	public static boolean checkString(String s) {
		if (s.length() != 2)
			return false;
		if (s.charAt(0) >= 'a' && s.charAt(0) <= 'j') {
			char tmpUppercase = Character.toUpperCase(s.charAt(0));
			s = tmpUppercase + s.substring(1);
		}
		if (s.charAt(0) < 'A' || s.charAt(0) > 'J')
			return false;
		if (s.charAt(1) < '1' || s.charAt(1) > '9')
			return false;
		return true;
	}
}
