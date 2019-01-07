package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The readFile class provide a static function load() that read the data from
 * the data set and load it into a state variable L which is the abstract data
 * type (ADT) array. L is also constructed in load() by calling the construct a
 * ADT constructor.
 * 
 * @author Jiamin
 *
 */
public class readFile {

	private static ADT[] L = new ADT[280896]; // ADT array to store the data from the data set

	private static String[] U1 = new String[140448]; // 2 Temporary String array to store the content because there are
														// 2 different type of unit data in the data set
	private static String[] U2 = new String[140448];

	public static void load() { // load() function is used to read file and load data.
		try {
			File file = new File("data\\data.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();

			for (int count = 0; count < 280896; count++) {
				if (count % 32 < 16)
					U1[count % 32 + count / 32 * 16] = bufferedReader.readLine(); // split then store
				else
					U2[count % 32 - 16 + count / 32 * 16] = bufferedReader.readLine(); // split then store
			}
			fileReader.close();
		} catch (IOException e) { // throw IOException
			e.printStackTrace();
		}
	}

	public static void construct() {
		// go through U1 first
		for (int i = 0; i < 140448; i++) {
			String[] test = U1[i].split("\""); // trim by splitting "
			int year = Integer.parseInt(test[0].substring(0, 4));// set year

			int age; // set age group
			if (test[3].split(",")[1].substring(1, 2).equals("a")) // determine age group by 5 cases then set
				age = -2;
			else if (test[3].split(",")[1].substring(1, 2).equals("n"))
				age = -1;
			else if (test[3].split(",")[1].substring(1, 2).equals("u"))
				age = 0;
			else if (test[3].split(",")[1].substring(1, 2).equals("o"))
				age = 90;
			else if ((int) test[3].split(",")[1].charAt(2) < (int) '0'
					|| (int) test[3].split(",")[1].charAt(2) > (int) '9')
				age = Integer.parseInt(test[3].split(",")[1].substring(1, 2));
			else
				age = Integer.parseInt(test[3].split(",")[1].substring(1, 3));

			int gender = -1; // set gender
			if (test[4].charAt(1) == 'B')
				gender = 0;
			else if (test[4].charAt(1) == 'M')
				gender = 1;
			else if (test[4].charAt(1) == 'F')
				gender = 2;

			String cause = "";// set cause
			double value = -1;
			if (test.length == 5) {
				String[] chunk = test[4].split(","); // trim by splitting ,
				cause = chunk[2].replaceAll(",", " "); // trim cause to avoid , in cause
				value = Double.parseDouble(chunk[chunk.length - 1]);
			}
			if (test.length == 7) {
				cause = test[5].replaceAll(",", " "); // trim by splitting ,
				String[] chunk = test[6].split(","); // trim cause to avoid , in cause
				value = Double.parseDouble(chunk[4]);
			}
			L[i] = new ADT(year, age, gender, cause, 0, value);
		}

		// go through U2
		for (int i = 0; i < 140448; i++) { // similar to U1 process
			String[] test = U2[i].split("\""); // set year
			int year = Integer.parseInt(test[0].substring(0, 4));

			int age; // set age
			if (test[3].split(",")[1].substring(1, 2).equals("a"))
				age = -2;
			else if (test[3].split(",")[1].substring(1, 2).equals("n"))
				age = -1;
			else if (test[3].split(",")[1].substring(1, 2).equals("u"))
				age = 0;
			else if (test[3].split(",")[1].substring(1, 2).equals("o"))
				age = 90;
			else if ((int) test[3].split(",")[1].charAt(2) < (int) '0'
					|| (int) test[3].split(",")[1].charAt(2) > (int) '9')
				age = Integer.parseInt(test[3].split(",")[1].substring(1, 2));
			else
				age = Integer.parseInt(test[3].split(",")[1].substring(1, 3));

			int gender = -1; // set gender
			if (test[4].charAt(1) == 'B')
				gender = 0;
			else if (test[4].charAt(1) == 'M')
				gender = 1;
			else if (test[4].charAt(1) == 'F')
				gender = 2;

			String cause = "";
			double value = -1;
			if (test.length == 7) {
				String[] chunk1 = test[4].split(",");
				cause = chunk1[2].replaceAll(",", " ");
				String[] chunk2 = test[6].split(",");
				value = Double.parseDouble(chunk2[3]);
			}

			if (test.length == 9) {
				cause = test[5].replaceAll(",", " ");
				String[] chunk = test[8].split(",");
				value = Double.parseDouble(chunk[3]);
			}
			L[i + 140448] = new ADT(year, age, gender, cause, 1, value);
		}
	}

	public static ADT getADT(int i) {
		return L[i];
	}

}
