package project;
//Modified to be a actually data storage structure
public class Data {
	private static ADT[][][] Ages1 = new ADT[22][3][];
	private static ADT[][][] Ages2 = new ADT[22][3][];
	private static String[] cause_all = new String[136];
	private static String[] cause_male = new String[129];
	private static String[] cause_female = new String[134];
//Modify the 4 functions below to avoid accidental data reload.
	private static void getcausea() {
		for (int i = 0; i < 136; i++) {
			cause_all[i] = readFile.getADT(i * 16).getCause();
		}
	}

	private static void getcausem() {
		for (int i = 0; i < 129; i++) {
			cause_male[i] = readFile.getADT(i * 16 + 16 * 136).getCause();
		}
	}

	private static void getcausef() {
		for (int i = 0; i < 134; i++) {
			cause_female[i] = readFile.getADT(i * 16 + 16 * (129 + 136)).getCause();
		}
	}

	private static void getgroup() {
		for (int i = 0; i < 22; i++) {
			Ages1[i][0] = new ADT[2176];
			Ages1[i][1] = new ADT[2064];
			Ages1[i][2] = new ADT[2144];
			for (int j = 0; j < 2176; j++) {
				Ages1[i][0][j] = readFile.getADT(i * 6384 + j);
				//System.out.println(ADT.getCause(Ages[i][0][j]));
			}
			for (int j = 0; j < 2064; j++) {
				Ages1[i][1][j] = readFile.getADT(i * 6384 + j + 2176);
			}
			for (int j = 0; j < 2144; j++) {
				 Ages1[i][2][j] = readFile.getADT(i * 6384 + j + 2176 + 2064);
			}
		}
		for (int i = 0; i < 22; i++) {
			Ages2[i][0] = new ADT[2176];
			Ages2[i][1] = new ADT[2064];
			Ages2[i][2] = new ADT[2144];
			for (int j = 0; j < 2176; j++) {
				Ages2[i][0][j] = readFile.getADT(140448+i * 6384 + j);
				//System.out.println(ADT.getCause(Ages[i][0][j]));
			}
			for (int j = 0; j < 2064; j++) {
				Ages2[i][1][j] = readFile.getADT(140448+i * 6384 + j + 2176);
			}
			for (int j = 0; j < 2144; j++) {
				 Ages2[i][2][j] = readFile.getADT(140448+i * 6384 + j + 2176 + 2064);
			}
		}
		
	}
//4 functions below are used to return data 
	public static String[] returnAC() {
		return cause_all;
	}
	
	public static String[] returnMC() {
		return cause_male;
	}
	
	public static String[] returnFC() {
		return cause_female;
	}
	
	public static ADT[][][] returnAge1() {
		return Ages1;
	}
	
	public static ADT[][][] returnAge2() {
		return Ages2;
	}
//setUp function. Assume to be called everytime before any return function.
	public static void setUp(){
		readFile.load();
		Data.getcausea();
		Data.getcausem();
		Data.getcausef();
		Data.getgroup();
	}
	
	public static void main(String[] args) {
		Data.setUp();
		for(int i = 0; i < Data.returnAge1()[8][0].length; i++) {
			System.out.println(Data.returnAge1()[8][0][i]);
		}
	}
	
}
