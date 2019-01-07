package project;

public class test {
	

	public static void main(String[] args) {
		
		readFile.load();
		
		 /*for (int i = 198546; i< 198546+1000; i++) {
		 System.out.println(ADT.getYear(readFile.getADT(i)));
		 System.out.println(ADT.getAge(readFile.getADT(i)));
		 System.out.println(ADT.getGender(readFile.getADT(i)));
		 System.out.println(ADT.getCause(readFile.getADT(i)));
		 System.out.println(ADT.getUnit(readFile.getADT(i)));
		 System.out.println(ADT.getValue(readFile.getADT(i))); }*/
		 
		
		String[] cause_all = new String[136];
		for (int i = 0; i < 136; i++) {
			cause_all[i] = readFile.getADT(i * 16).getCause();
		}

		String[] cause_male = new String[129];
		for (int i = 0; i < 129; i++) {
			cause_male[i] = readFile.getADT(i * 16 + 16 * 136).getCause();
		}

		String[] cause_female = new String[134];
		for (int i = 0; i < 134; i++) {
			cause_female[i] = readFile.getADT(i * 16 + 16 * (129 + 136)).getCause();
		}

		ADT[][][] Ages = new ADT[22][3][];
		for (int i = 0; i < 17; i++) {
			Ages[i][0] = new ADT[2176];
			Ages[i][1] = new ADT[2064];
			Ages[i][2] = new ADT[2144];
			for (int j = 0; j < 2176; j++) {
				
				//System.out.println(ADT.getAge(Ages[i][0][j]));
			}
			for (int j = 0; j < 2064; j++) {
			}
			for (int j = 0; j < 2064; j++) {
			}
		}
		
		Data.setUp();
		//writeFile.write();
	}

}
