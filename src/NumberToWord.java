
public class NumberToWord {

	public static String[] specialNames = new String[] { "", " Thousand", " Million", " Billion", " Trillion",
			" Quadrillion", " Quintillion" };

	public static String[] tenNames = new String[] { "", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty",
			" Seventy", " Eighty", " Ninety" };

	public static String[] numNames = new String[] { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven",
			" Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen",
			" Seventeen", " Eighteen", " Nineteen" };

	public static void main(String[] args) {
		String s = new String("23104382426112");
		String result = convert(s);
		System.out.println(result);
	}

	private static String convert(String s) {

		String result = "";
		boolean isNegative = false;
		if (s.startsWith("-")) {
			isNegative = true;
			s = s.substring(1);
		}
		long number = Long.parseLong(s);
		if (number == 0) {
			return "zero";
		}
		int place = 0;
		do {
			long n = number % 1000;
			if (n != 0) {
				String current = convertLessThanThousand(number % 1000);
				result = current + specialNames[place] + result;
			}
			place++;
			number /= 1000;
		} while (number > 0);
		return result.trim();
	}

	private static String convertLessThanThousand(long number) {

		String result = "";
		if (number % 100 < 20) {
			result = result + numNames[(int) number % 100];
			number /= 100;
		} else {
			result = result + numNames[(int) number % 10];
			number /= 10;

			result = tenNames[(int) number % 10] + result;
			number /= 10;
		}
		if (number == 0) {
			return result;
		}
		return numNames[(int) number] + " Hundred" + result;

	}
}
