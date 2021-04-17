
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class BenziUtils {

	public static String randomCarManufacturer() {
		String[] s = { "Toyota", "Volkswagen Group", "Hyundai / Kia", "General Motors", "(with SAIC-GM-Wuling)[d]",
				"Ford", "Nissan", "Honda", "FCA", "Renault", "Groupe PSA", "Suzuki", "SAIC", "Daimler", "BMW", "Geely",
				"Changan", "Mazda", "Dongfeng Motor", "BAIC", "Mitsubishi" };
		int i = (int) (Math.random() * s.length);
		return s[i];
	}

	public static Date generateRandomDate() {
		return generateDateJava(randIntBetween(1960, 2030), // year
				randIntBetween(1, 12), // month
				randIntBetween(1, 27)); // day
	}

	public static java.util.Date generateDateJava(int year, int month, int day) { // Moti
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1); // 0 = January, 11 = December
		calendar.set(Calendar.DAY_OF_MONTH, day); // 1 to 31
		return (java.util.Date) calendar.getTime();
	}

	public static String generateColour() {
		String[] s = { "Red", "Blue", "Green", "White", "Black" };
		int i = (int) (Math.random() * s.length);
		return s[i];
	}

	public static int randIntBetween(int min, int max) { // 1 10
		int c = (int) (Math.random() * (max - min + 1) + min);
		return c;
	}

	public static double randBetween(double min, double max) {
		double c = Math.random() * (max - min) + min;
		return c;
	}

//  String.format("%.1f")  

	public static double randomNumFromList(double... numbers) { // Var Args...
		int i = (int) (Math.random() * numbers.length);
		return numbers[i];
	}

	public static void print(List<?> list) { // <?> = Generic (L24);
		for (Object o : list) {
			System.out.println(o);
		}
	}

	public static String generateTel() {
		int n = (int) Math.round(Math.random() * (99999999 - 10000000) + 10000000);
		String tel = "05" + n;
		tel = tel.substring(0, 3) + "-" + tel.substring(3, 6) /* + "-" */ + tel.substring(6, 10);
		return tel;
	}

	public static String generateABCletter() {
		String[] s = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z" };
		int i = (int) (Math.random() * s.length);
		return s[i];
	}

	public static String generateName() {
		String[] namesArr = { "DAVID", "MICHAEL", "BAR", "GOSEPPE", "MOSHE", "SIGAL", "BENTZI", "DORON", "ANGELA",
				"GOLDA", "YENTA", "TUVYA", "MOTI" };
		int i = (int) (Math.random() * namesArr.length);
		return namesArr[i];
	}

	public static String generateFood() {
		String[] namesArr = { "Falafel", "Pizza", "Apple", "Soup", "Rice", "Pasta", "Shwarma", "Broccoli", "Cabbage",
				"Hummus" };
		int i = (int) (Math.random() * namesArr.length);
		return namesArr[i];
	}

	public static String generateCity() {
		String[] s = { "Tel Aviv", "Haifa", "Bat Yam", "Rishon", "Ramat Gan", "Petah Tikva", "Bnei Brak", "Holon" };
		int i = (int) (Math.random() * s.length);
		return s[i];
	}

	public static int[] buildNullArray(int length) {
		int[] array = new int[length];
		return array;
	}

	public static int[] buildRandomArray(int length) {
		int[] array = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 101);
		}
		return array;
	}

	public static int[] buildRandomArrayWithBoundaries(int length, int min, int max) {
		int[] array = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * (max - min) + min);
		}
		return array;
	}

	public static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
	}

	public static double[] SumAverageMaxAndMin(double... numbers) { // Var Args...
		double sum = 0;
		double average = 0;
		double max = numbers[0];
		double min = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i];
			average = average * i / (i + 1) + numbers[i] * 1 / (i + 1);
			if (numbers[i] > max) {
				max = numbers[i];
			} // יחי המלך החדש
			if (numbers[i] < min) {
				min = numbers[i];
			} // יבורך התינוק הנולד
		}
		double[] results = { sum, average, max, min };

		System.out.println("For the following numbers:");
		System.out.println(Arrays.toString(numbers));
		System.out.println("Sum; Average; Max; Min:");
		System.out.println(Arrays.toString(results));
		return results;
	}

	public static int numberOfDigits(int number) {

		int digits = 0;
		while (number > 0) {
			number = number / 10;
			digits++;
		}
		return digits;
	}

}
