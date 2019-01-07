package project;

import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
	public static void write() {
		Data.setUp();
		String[] causes = Data.returnAC();
		String abc = ",";
		try {
			FileWriter writer = new FileWriter("data/riskFactors.csv");
			for (String w : causes) {
				w = w.replaceAll(",", abc);
				writer.write(w + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
